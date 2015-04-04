package com.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReplaceUtil {

	public static void main(String[] args) throws IOException{
		File oleFile = new File("E:/workspace/wolf-study/src/main/resources/oldfile.txt");
		File newFile = new File("E:/workspace/wolf-study/src/main/resources/newfile.txt");
		File file3 = new File("E:/workspace/wolf-study/src/main/resources/dmdfile.txt");
		
		List<String> oldLines = FileUtils.readLines(oleFile);
		List<String> newLines = FileUtils.readLines(newFile);
		String dmdStr = FileUtils.readFileToString(file3);
		
		for(int i=0; i<oldLines.size(); i++){
//			System.out.println(oldLines.get(i)+"="+newLines.get(i));
			dmdStr = dmdStr.replace(oldLines.get(i), newLines.get(i));
		}

		
		System.out.println(dmdStr);
	}
	

}
