package com.study.open.commonLang;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class StringUtilsTest {


	public static void  testBlank(){
	    String test = "";
	    String test2 = "\n\n\t";
	    String test3 = null;
	    String test4 = "Test";
	    System.out.println( "test blank? " + StringUtils.isBlank( test ) );
	    System.out.println( "test2 blank? " + StringUtils.isBlank( test2 ) );
	    System.out.println( "test3 blank? " + StringUtils.isBlank( test3 ) );
	    System.out.println( "test4 blank? " + StringUtils.isBlank( test4 )	);	
	}
	public static void testTrim(){
	    String test1 = "\t";
	    String test2 = "  A  Test  ";
	    String test3 = null;

	    System.out.println( "test1 trimToNull: " + StringUtils.trimToNull( test1 ) );
	    System.out.println( "test2 trimToNull: " + StringUtils.trimToNull( test2 ) );
	    System.out.println( "test3 trimToNull: " + StringUtils.trimToNull( test3 ) );
	    
	    System.out.println( "test1 trim: " + StringUtils.trim( test1 ) );
	    System.out.println( "test2 trim: " + StringUtils.trim( test2 ) );
	    System.out.println( "test3 trim: " + StringUtils.trim( test3 ) );
	    
	    System.out.println( "test1 trimToEmpty: " + StringUtils.trimToEmpty( test1 ) );
	    System.out.println( "test2 trimToEmpty: " + StringUtils.trimToEmpty( test2 ) );
	    System.out.println( "test3 trimToEmpty: " + StringUtils.trimToEmpty( test3 ) );	    
	}
	
	public static void testSplit(){
	    String input = "A b,c.d|e";
	    String input2 = "Pharmacy, basketball funky";
	   

	    String[] array1 = StringUtils.split( input, " ,.|");
	    String[] array2 = StringUtils.split( input2, " ,", 2 );
	    String[] array3 = StringUtils.split( input2, " ,");
	    System.out.println( ArrayUtils.toString( array1 ) );
	    System.out.println( ArrayUtils.toString( array2 ) );
	    System.out.println( ArrayUtils.toString( array3 ) );
	}
	public static void testAbbreviate(){
	    String test = "This is a test of the abbreviation.";
	    String test2 = "Test";

	    System.out.println( StringUtils.abbreviate( test, 15 ) );
	    System.out.println( StringUtils.abbreviate( test, 5,15 ) );
	    System.out.println( StringUtils.abbreviate( test2, 10 ) );		
		
	}
	public static void testSubstringBetween(){
	    String htmlContent = "ABC1234ABC4567";
	        System.out.println(StringUtils.substringBetween(htmlContent, "1234", "4567"));
	        System.out.println(StringUtils.substringBetween(htmlContent, "12345", "4567"));		
	}
	public static void testChomp(){
	    String input = "Hello\n";
	    System.out.println( StringUtils.chomp( input ));
	    String input2 = "Another test\r\n";
	    System.out.println( StringUtils.chomp( input2 ));	
	    String input3 = "Another test\r\n\t";
	    System.out.println( StringUtils.chomp( input3 ));		    
	}
	public static void testRepeat(){
		System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>testRepeat");
	    System.out.println( StringUtils.repeat( "*", 10));
	    System.out.println( StringUtils.repeat( "China ", 5));	
	    
	    System.out.println( StringUtils.center( "China", 11,"*"));
	    System.out.println( StringUtils.leftPad("China", 10, "0"));
	}
	public static void testReverser(){
		System.out.println( StringUtils.reverse("ABCDE"));
	}
	public static void testIsAlpha(){
	    String state = "Virginia2";
	    System.out.println( "Is state number? " + StringUtils.isNumeric(state ) );
	    System.out.println( "Is state alpha? " + StringUtils.isAlpha( state ));
	    System.out.println( "Is state alphanumeric? " +StringUtils.isAlphanumeric( state ) );
	    System.out.println( "Is state alphaspace? " + StringUtils.isAlphaSpace( state ) );		
	}
	public static void testCountMatches(){
		System.out.println(StringUtils.countMatches( "Chinese People", "e"));
	}
	public static void testSubstring(){
	    String formatted = " 25 * (30,40) [50,60] | 30";
	    System.out.println("N0: " + StringUtils.substringBeforeLast( formatted, "*" ) );
	    System.out.println(", N1: " + StringUtils.substringBetween( formatted, "(", "," ) );
	    System.out.println(", N2: " + StringUtils.substringBetween( formatted, ",", ")" ) );
	    System.out.println(", N3: " + StringUtils.substringBetween( formatted, "[", "," ) );
	    System.out.println(", N4: " + StringUtils.substringBetween( formatted, ",", "]" ) );
	    System.out.println(", N5: " + StringUtils.substringAfterLast( formatted, "|" ) );		
	}
	
	public static void testEmpty(){
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty(" "));
		System.out.println(StringUtils.isEmpty("bob"));
		System.out.println(StringUtils.isEmpty(" bob "));	
	}
	public static void testEquals(){
		System.out.println("###############test equal");
		System.out.println(StringUtils.equals(null, null));
		System.out.println(StringUtils.equals(null, "abc"));
		System.out.println(StringUtils.equals("abc", null));
		System.out.println(StringUtils.equals("abc", "abc"));
		System.out.println(StringUtils.equals("abc", "ABC"));
		System.out.println(StringUtils.equalsIgnoreCase("abc", "ABC"));
		
	}
	public static void main(String[] args){
		testBlank();
		testTrim();
		testSplit();
		testAbbreviate();
		testChomp();
		testRepeat();
		testReverser();
		testIsAlpha();
		testCountMatches();
		testSubstring();
		testEmpty();
		testEquals();
	}	
}
