package com.study.javase.io;

import java.io.File;
import java.io.IOException;

public class DelDir {

	public static void del(String filePath) throws IOException{
		File f = new File(filePath);
		if(f.exists() && f.isDirectory()){
			if(f.listFiles().length ==0){
				f.delete();
			}else{
				File[] delFile = f.listFiles();
				for(int j=0; j<delFile.length; j++){
					if(delFile[j].isDirectory()){
						del(delFile[j].getAbsolutePath());
					}
					delFile[j].delete();
				}
			}
			del(filePath);
		}
	}
	public static void move(String srcfile, String destfile){
		new File(srcfile).renameTo(new File(destfile));
	}
	public static void main(String[] args) throws IOException{
		//String filePath = "";
		//del(filePath);
		try{
		String srcfile = "E:/TDDOWNLOAD/jdk1.5.0_15.html";
		String destfile = "F:/TDDOWNLOAD/test/jdk1.5.0_15.htm";
		move(srcfile, destfile);
		String filePath = "F:/TDDOWNLOAD/test";
		del(filePath);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
