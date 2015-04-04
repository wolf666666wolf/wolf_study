package com.study.javase.refacting.simplizeCall;
/**
 * 某个函数即返回函数状态又修改函数状态，可以吧函数拆成两个，一个负责查询，一个负责修改
 * @author BULL
 *
 */
public class Rule10_4_SeparateQueryFromModifier {
	public void checkSecurity(String[] people){
		String found = this.findMiscreant(people);
		otherCode(found);
	}
	public String findMiscreant(String[] people){
		for(int i=0; i<people.length; i++){
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
	private void otherCode(String foundPerson){}
	private void sendAlert(){
		System.out.println("Alert----");
	}	
}

//after refacting
class SeparateQueryFromModifier{
	public void checkSecurity(String[] people){
		findMiscreant(people);
		String found = this.findPerson(people);
		otherCode(found);
	}
	
	public void findMiscreant(String[] people){
		this.sendAlert(people);
	}	
	public String findPerson(String[] people){
		for(int i=0; i<people.length; i++){
			if(people[i].equals("Don")){
				return "Don";
			}
			if(people[i].equals("John")){
				return "John";
			}
		}
		return "";
	}
	private void otherCode(String foundPerson){}
	private void sendAlert(String[] people){
		if(!this.findPerson(people).equals("")){
			sendAlert();
		}
	}
	private void sendAlert(){
		System.out.println("Alert----");
	}	
}
