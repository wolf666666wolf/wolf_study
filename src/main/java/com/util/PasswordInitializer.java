package com.util;


public class PasswordInitializer {
//	private static LogUtils log = LogUtils.getLogger(PasswordInitializer.class);

	private static final char[] LOWER_LETTERS = { 'u', 'v', 'w', 'x', 'y', 'z', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 'a', 'b', 'c', 'd', 'e', 'f',
		'g', 'h', 'i', 'j', 't' };
	private static final char[] UPPER_LETTERS = { 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
		'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D',
		'E', 'F', 'G', 'H', 'I' };
	/**
	 * generate Initial password
	 * 
	 * @author HHQ
	 * @param text
	 * @throws SecurityServiceException
	 */
	public String initial() {
//		char[] lowerLetters = { 'u', 'v', 'w', 'x', 'y', 'z', 'k', 'l', 'm',
//				'n', 'o', 'p', 'q', 'r', 's', 'a', 'b', 'c', 'd', 'e', 'f',
//				'g', 'h', 'i', 'j', 't' };
//		char[] upperLetters = { 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
//				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D',
//				'E', 'F', 'G', 'H', 'I' };
		

		char[] passwordText = new char[12];
		
		int[] digitals = initDigitals();
		passwordText[0] = Integer.valueOf(digitals[0]).toString().charAt(0);// New
																			// Integer->Integer.valueOf
																			// for
																			// Sonar,2012-03-16
		passwordText[1] = LOWER_LETTERS[digitals[1]];
		passwordText[2] = Integer.valueOf(digitals[2]).toString().charAt(0);// New
																			// Integer->Integer.valueOf
																			// for
																			// Sonar,2012-03-16
		passwordText[3] = UPPER_LETTERS[digitals[3]];
		passwordText[4] = UPPER_LETTERS[digitals[4]];
		passwordText[5] = Integer.valueOf(digitals[5]).toString().charAt(0);// New
																			// Integer->Integer.valueOf
																			// for
																			// Sonar,2012-03-16
		passwordText[6] = LOWER_LETTERS[digitals[6]];
		passwordText[7] = UPPER_LETTERS[digitals[7]];
		passwordText[8] = LOWER_LETTERS[digitals[8]];
		passwordText[9] = UPPER_LETTERS[digitals[9]];
		passwordText[10] = Integer.valueOf(digitals[2]).toString().charAt(0);// New
																				// Integer->Integer.valueOf
																				// for
																				// Sonar,2012-03-16
		passwordText[11] = LOWER_LETTERS[digitals[5]];
		return new String(passwordText);
	}

	private int[] initDigitals() {
		int digitalsLen = 10;
		int[] digitals = new int[digitalsLen];		
		java.util.Random r = new java.util.Random();
		for (int i = 0; i < digitalsLen; i++) {
			digitals[i] = r.nextInt(digitalsLen);
		}
		return digitals;
	}
	
	
	public static void main(String[] args){
		PasswordInitializer pwdInit = new PasswordInitializer();
		for(int i=0; i<12; i++){
			System.out.println("password"+i+":" +pwdInit.initial());
		}
	}
}
