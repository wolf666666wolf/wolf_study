package com.study.javase.thread.download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadThread extends Thread{
	private String url = null;
	private String file = null;
	private long offset = 0;//偏移量
	private long length = 0;//本线程下载的字节数
	
	public DownloadThread(String url, String file, long offset, long length){
		this.url = url;
		this.file = file;
		this.offset = offset;
		this.length = length;
	}
	public void run(){
		try {
			HttpURLConnection httpConnection = (HttpURLConnection)new URL(this.url).openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("RANGE", "bytes="+this.offset+"-"+(this.offset+this.length-1));
			BufferedInputStream bis = new BufferedInputStream(httpConnection.getInputStream());
			byte[] buff= new byte[1024];
			int bytesRead;
			while(-1 != (bytesRead = bis.read(buff, 0, buff.length))){
				this.writeFile(this.file, this.offset, buff, bytesRead);
				this.offset = this.offset + bytesRead;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeFile(String fileName, long offset, byte[] bytes, int realLength) throws IOException{
		File newFile = new File(fileName);
		RandomAccessFile raf = new RandomAccessFile(newFile, "rw");
		raf.seek(offset);
		raf.write(bytes, 0, realLength);
		raf.close();
	}

}
