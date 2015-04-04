package com.study.javase.regex;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {

	
	public static void main(String[] args){
		String str = "第一句。第二句！第三句：第四句；第五句。www";
		String regEx="：|。|！|；"; 

		
//		StringToken word:第一句
//		StringToken word:第二句
//		StringToken word:第三句
//		StringToken word:第四句
//		StringToken word:第五句			
		stringTokenWithoutSpliter(str, regEx);
	
//		StringToken word:第一句		
//		StringToken word:。
//		StringToken word:第二句
//		StringToken word:！
//		StringToken word:第三句
//		StringToken word:：
//		StringToken word:第四句
//		StringToken word:；
//		StringToken word:第五句
//		StringToken word:。		
		stringTokenWithSpliter(str, regEx);
		
		
//		word = 第一句
//		word = 第二句
//		word = 第三句
//		word = 第四句
//		word = 第五句		
		stringSplitWithoutSpliter(str, regEx);	
		
//		word = 第一句。
//		word = 第二句！
//		word = 第三句：
//		word = 第四句；
//		word = 第五句。		
		stringSplitWithSpliter(str, regEx);
		
		
		testReplaceAll();
		
		testAppend();
	}
	private static void testAppend(){
		String reg="\\w+";
		String input = "-->one+test<--";
		Matcher m = Pattern.compile(reg).matcher(input);
		StringBuffer sb = new StringBuffer(); 
		while(m.find()){
			m.appendReplacement(sb, "XXX");
		}
		System.out.println(">>>>>>>>>>>>>>>>:"+sb.toString());
		m.appendTail(sb);
		System.out.println(">>>>>>>>>>>>>>>>:"+sb.toString());		
	}
	
	
	private static void testReplaceAll(){
	   String REGEX = "a*b"; 
	   String INPUT = "aabfooaabfooabfoob"; 
	   String REPLACE = "-"; 
       Pattern p = Pattern.compile(REGEX); 
       Matcher m = p.matcher(INPUT);       // 获得匹配器对象 
       while(m.find()){
    	   System.out.println("group:"+m.group());
       }
       INPUT = m.replaceAll(REPLACE); 
       System.out.println("#####:"+INPUT); 		
	}
	
	/**
	 * string token, the result without spliter
	 * @param str
	 * @param regEx
	 */
	private static void stringTokenWithoutSpliter(String str, String regEx){
//	      StringTokenizer strToke=new StringTokenizer(str,":");//默认不打印分隔符
//	      StringTokenizer strToke=new StringTokenizer(str,":",true);//打印分隔符
	      StringTokenizer strToke=new StringTokenizer(str, regEx, false);//不打印分隔符	
	      while(strToke.hasMoreElements()){
	    	  
	         System.out.println("StringToken word:"+strToke.nextToken());
	         //System.out.println(strToke.nextElement()); //效果同上
	       }	      
	}
	/**
	 * string token, the result without spliter
	 * @param str
	 * @param regEx
	 */
	private static void stringTokenWithSpliter(String str, String regEx){
//	      StringTokenizer strToke=new StringTokenizer(str,":");//默认不打印分隔符
	      StringTokenizer strToke=new StringTokenizer(str,regEx,true);//打印分隔符
//	      StringTokenizer strToke=new StringTokenizer(str, regEx, false);//不打印分隔符	
	      while(strToke.hasMoreElements()){
	    	  
	         System.out.println("StringToken word:"+strToke.nextToken());
	         //System.out.println(strToke.nextElement()); //效果同上
	       }	      
	}	
	/**
	 * String split, the result without spliter
	 * @param str
	 * @param regEx
	 */
	private static void stringSplitWithoutSpliter(String str, String regEx){
		Pattern p =Pattern.compile(regEx);
		Matcher m = p.matcher(str); 
		String[] words = p.split(str); 
		
		for(int index = 0; index < words.length; index++)  
		{  
		    String word = words[index];  
		    System.out.println("word = " + word);  
		}		
	}
	/**
	 * String split, the result without spliter
	 * @param str
	 * @param regEx
	 */
	private static void stringSplitWithSpliter(String str, String regEx){
		Pattern p =Pattern.compile(regEx);
		Matcher m = p.matcher(str); 
		String[] words = p.split(str); 

		if(words.length > 0)  {  
		    int index=0;
			int count = 0;  
		    while(count < words.length)  {  
		        if(m.find())  {  
//		        	System.out.println("#####:"+str.substring(index, m.start()));
		        	System.out.println("#####group:"+m.group());
		        	index = m.start();
		            words[count] += m.group();  
		        }  
		        count++;  
		    } 
		    System.out.println("#####:"+str.substring(index));
		}
		for(int index = 0; index < words.length; index++)  
		{  
		    String word = words[index];  
		    System.out.println("word = " + word);  
		} 		
	}	
	private static String getMockData(){
		StringBuilder sb = new StringBuilder();
		sb.append("<txt>Risk Points when TRUE</txt>");
		sb.append("<txt>C_R107_A1_SCORE</txt>");
		sb.append("<txt>REFERENCE: R107-A2</txt>");
		sb.append("<txt>Criterion</txt>");
		sb.append("<txt>Description</txt>");
		sb.append("<txt>On submission of Form 24</txt>");
		return sb.toString();
	}
}

