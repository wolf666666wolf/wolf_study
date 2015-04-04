package com.study.javase.regex;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegFilter {

	private List files = new ArrayList();
	private String path;
	private String regexp;
	

	public static void main(String[] args){
		
	}

	RegFilter(String path, String regexp){
		getFileNames(path, regexp);
	}	
	
	

	
	private void getFileNames(String path, String regexp){
		this.path = path;
		this.regexp = regexp;
		File directory = new File(path);
		File[] dirfiles = directory.listFiles(new MyFileFilter());
		
		if(dirfiles == null){
			return;
		}
		for(int j=0; j<dirfiles.length; j++){
			files.add(dirfiles[j]);
		}
	}
	
	
	class MyFileFilter implements FileFilter{
		
		@Override
		public boolean accept(File file){
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(file.getName());
			return matcher.matches();
		}

	}

}

