package com.study.javase.thread.download;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadManager {
	static final long unitSize = 10*1024;
	
	private long getRemoteFileSize(String remoteFileUrl) throws  IOException{
		long result = 0;
		HttpURLConnection httpConnection = (HttpURLConnection)new URL(remoteFileUrl).openConnection();
		httpConnection.setRequestMethod("HEAD");
		for(int i=1; i<=10; i++){
			if(httpConnection.getHeaderFieldKey(i).equalsIgnoreCase("Content-Length")){
				result = Long.parseLong(httpConnection.getHeaderField(i));
				break;
			}
		}
		return result;
	}
	private void createFile(String fileName, long fileSize) throws IOException{
		File newFile = new File(fileName);
		RandomAccessFile raf = new RandomAccessFile(newFile, "rw");
		raf.setLength(fileSize);
		raf.close();
	}
	
	public void doDownload(String remoteFileUrl, String localFileName) throws IOException{
		long fileSize = this.getRemoteFileSize(remoteFileUrl);
		this.createFile(localFileName, fileSize);
		long threadCount = fileSize/unitSize;
		System.out.println("共启动线程" +(fileSize % unitSize == 0? threadCount: threadCount +1)+ "个");
		long offset=0;
		if(fileSize <=unitSize){
			DownloadThread downloadThread = new DownloadThread(remoteFileUrl, localFileName, offset, fileSize);
			downloadThread.start();
		}else{
			for(int i=1; i<=threadCount; i++){
				DownloadThread downloadThread = new DownloadThread(remoteFileUrl, localFileName, offset, unitSize);
				downloadThread.start();
				offset = offset + unitSize;
			}
			if(fileSize % unitSize != 0){
				DownloadThread downloadThread = new DownloadThread(remoteFileUrl, localFileName, offset, fileSize - unitSize*threadCount);
				downloadThread.start();
			}
		}	
	}
	
	public static void main(String[] args){
		//String remoteFileUrl = "http://list.image.baidu.com/t/image_category/image_funny.html";
		
		String remoteFileUrl = "http://img.bimg.126.net/photo/uQ9scsm0gUYiujyNmmFsOA==/2852467413986568581.jpg";
		String localFileName = "F:/tmp/test.html";
		DownloadManager dm = new DownloadManager();
		try {
			dm.doDownload(remoteFileUrl, localFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
