package com.study.open.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {

	private static Log log = LogFactory.getLog(LogTest.class);
	public static void main(String[] args){
		test();
	}
	
	public static void test(){
		log.debug("##########DEBUG");
		log.info("##########INFO");
		log.warn("##########WARN");
		log.error("##########ERROR");
		log.fatal("##########FATAL"); 
		
	}
}
