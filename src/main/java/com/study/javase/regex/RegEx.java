package com.study.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args){
		search();
		fetch();
		split();
		replace();
	}
	public static void search(){
		String str="abc efg ABC";
		String regEx="a|f";
		Pattern p=Pattern.compile(regEx);
		//Pattern p=Pattern.compile(regEx,Pattern.CASE_INSENSITIVE); //case insensitive
		Matcher m=p.matcher(str);
		boolean rs = m.find();
		
		System.out.println("groupCount:"+m.groupCount());
		System.out.println("group:"+m.group());
	}
	
	public static void fetch(){
		String regEx=".+\\\\(.+)$";
		String str="c:\\dir1\\dir2\\name.txt";
		
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(str);
		
		boolean rs=m.find();
		System.out.println("rs:"+rs);
		for(int i=0;i<=m.groupCount();i++){
			System.out.println("group["+i+"]:"+m.group(i));
		}
		
		System.out.println("str:"+str);
		System.out.println("regEx:"+regEx);
	}
	
	public static void split(){
		String regEx="::";
		Pattern p=Pattern.compile(regEx);
		String[] r=p.split("xd::abc::cde");
		
		for(int i=0; i< r.length; i++){
			System.out.println("r["+i+"]="+r[i]);
		}
	}
	
	public static void replace(){
		String regEx="a+";
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher("aaabbced a ccdeaa");
		String s=m.replaceAll("A"); 
		System.out.println("s="+s);
	}
}
