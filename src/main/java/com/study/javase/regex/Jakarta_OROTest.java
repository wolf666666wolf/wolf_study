package com.study.javase.regex;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

public class Jakarta_OROTest {
	public static void main(String[] args){
		
	}
	
	
	  private void containMatch(String inputValue, String reg) {
	
		  // System.out.println("containMatch----");
	
		  PatternCompiler compiler = new Perl5Compiler();
		
		  PatternMatcher matcher = null;
		
		  Pattern pattern = null;
		
		  String input = inputValue;
		
		  String regexp = reg;
		
		  try {
		
			  pattern = compiler.compile(regexp, Perl5Compiler.CASE_INSENSITIVE_MASK);
		
			  matcher = new Perl5Matcher();
		
			  if (matcher.contains(input, pattern)) {
		
				  	MatchResult result = matcher.getMatch();
		
				  	System.out.println("result =" + result.group(0));
		
		  // System.out.println("result ="+result.group(1));
		
			  }
		
		  }catch (MalformedPatternException e) {
		
			  System.err.println("containMatch ---Bad pattern.");
		
			  System.err.println(e.getMessage());
		
			  System.exit(1);
		
		  }

	}	
}
