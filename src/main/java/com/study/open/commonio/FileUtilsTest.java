package com.study.open.commonio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.ArrayUtils;

public class FileUtilsTest {

	public static void main(String[] args){
		testNormal();
		testReadURL();
		testReadFile();
		testFileName();
		testFindDrive();
		testFilter();
		testCopy();
	}
	public static void testNormal(){
		InputStream in = null;
		try{
			in = new URL("http://mail.tom.com/").openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("#############################start");
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			System.out.println("#############################end");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			in.close();
			}catch(Exception e){}
		}
	}
	public static void testReadURL(){
		InputStream in = null;
	
		try{
			in = new URL("http://mail.tom.com/").openStream();
			System.out.println(IOUtils.toString(in));
		}catch(Exception e){
			
		}finally{
			IOUtils.closeQuietly(in);
		}
	}
	public static void  testReadFile(){
		
		String fileName = FileUtilsTest.class.getResource("file.txt").getPath();
		System.out.println("path:" + fileName);
		File file = new File(fileName);
		
		List<String> lines = null;
		try{
			lines = FileUtils.readLines(file, "UTF-8");
		}catch(Exception e){}
		for(String line: lines){
			System.out.println(line);
		}
	}
	public static void testFileName(){
		String filename = FileUtilsTest.class.getResource("file.txt").getPath();
		System.out.println("baseName:"+FilenameUtils.getBaseName(filename));
		System.out.println("extension:"+FilenameUtils.getExtension(filename));
		System.out.println("name:"+FilenameUtils.getName(filename));
		System.out.println("path:"+FilenameUtils.getPath(filename));
		System.out.println("getPathNoEndSeparator:"+FilenameUtils.getPathNoEndSeparator(filename));
		System.out.println("prefix:"+FilenameUtils.getPrefix(filename));
	}
	public static void testFindDrive(){
		long space = 0;
		try{
			space = FileSystemUtils.freeSpaceKb("c:/");
		}catch(Exception e){}
		System.out.println("Space:" + space/1023 + "MB");
	}
	
	public static void testFilter(){
		File rootDir = new File("/");
		FilenameFilter filter = new SuffixFileFilter(".rar");
		String[] names = rootDir.list(filter);
		System.out.println("Filenames:" + ArrayUtils.toString(names));
		
		File dir = new File("K:/TMP");
		FilenameFilter orfilter = new OrFileFilter(new SuffixFileFilter("xml"), new SuffixFileFilter("ffm"));
		String[] ornames = dir.list(orfilter);
		System.out.println("Filenames:" + ArrayUtils.toString(ornames));
	}
	
	public static void testCopy(){
		String srcfile = FileUtilsTest.class.getResource("file.txt").getPath();
		//String destfile = srcfile+".bak";
		File srcFile = new File(srcfile);
		File destFile = new File(srcfile + ".bak");
		if(destFile.exists()){
			destFile.delete();
		}
		try{
			FileUtils.copyFile(srcFile, destFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("##############exist:"+destFile.exists());
		System.out.println("##############exist:"+destFile.getPath());
	}
}
