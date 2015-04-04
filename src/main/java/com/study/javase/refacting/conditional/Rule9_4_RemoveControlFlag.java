package com.study.javase.refacting.conditional;
/**
 * 在一系列表达式中，某个变量有"控制标记"的作用
 * 用 return 或 break 或 continue代替
 * @author BULL
 *
 */
public class Rule9_4_RemoveControlFlag {

	public void bagMethod(String[] people){
		String found = "";
		for(int i=0; i< people.length; i++){
			if(found.equals("")){
				if(people[i].equals("Don")){
					sendAlert();
					found = "Don";
				}
				if(people[i].equals("John")){
					sendAlert();
					found = "John";
				}
			}
		}
		continueFound(found);
	}
	
	private void goodMethod(String[] people){
		String foundpeople = this.foundPeople(people);
		continueFound(foundpeople);
	}
	
	private String foundPeople(String[] people){
		for(int i=0; i< people.length; i++){
				if(people[i].equals("Don")){
					sendAlert();
					return "Don";
				}
				if(people[i].equals("John")){
					sendAlert();
					return "John";
				}
		}	
		return "";
	}
	private void continueFound(String found){
		
	}
	private void sendAlert(){
		System.out.println("Alert++++++");
	}
}
