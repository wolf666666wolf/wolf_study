package com.study.javase.enu;

public enum Color {
	 RED("RED"), GREEN("GREEN"), BLUE("BLUE"), UNKNOWN("UNKNOWN");   
	  
	 private final String value;   
	  
	 Color(String value) {   
	   this.value = value;   
	 }   
	  
	 public static Color fromValue(String value) {   
	   if (value != null) {   
	     for (Color color : values()) {   
	       if (color.value.equals(value)) {   
	         return color;   
	       }   
	     }   
	   }   
	  
	   // you may return a default value   
	   return getDefault();   
	   // or throw an exception   
	   // throw new IllegalArgumentException("Invalid color: " + value);   
	 }   
	  
	 public String toValue() {   
	   return value;   
	 }   
	  
	 public static Color getDefault() {   
	   return UNKNOWN;   
	 } 
}
