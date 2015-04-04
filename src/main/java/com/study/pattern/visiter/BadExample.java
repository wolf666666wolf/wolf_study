package com.study.pattern.visiter;

public class BadExample {

	public static void main(String[] args){
		Person1 man = new Man1();
		Person1 woman = new Woman1();
		
		man.setAction(PersonState1.SUCCESS);
		man.getConsulation();
		woman.setAction(PersonState1.SUCCESS);
		woman.getConsulation();
		man.setAction(PersonState1.FAILED);
		man.getConsulation();
		woman.setAction(PersonState1.FAILED);
		woman.getConsulation();
		man.setAction(PersonState1.LOVE);
		man.getConsulation();
		woman.setAction(PersonState1.LOVE);
		woman.getConsulation();		
	}
}

abstract class Person1{
	private String action;

	public abstract void getConsulation();
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
class Man1 extends Person1{
	@Override
	public void getConsulation() {
		if(this.getAction().equals(PersonState1.SUCCESS)){
			System.out.println("男人成功时，背后多有一个伟大的女人");
		}else if(this.getAction().equals(PersonState1.FAILED)){
			System.out.println("男人失败时，喝闷酒，谁也不用劝");
		}else if(this.getAction().equals(PersonState1.LOVE)){
			System.out.println("男人恋爱时，凡事不懂也要装懂");
		}
		
	}
	
}
class Woman1 extends Person1{
	@Override
	public void getConsulation() {
		if(this.getAction().equals(PersonState1.SUCCESS)){
			System.out.println("女人成功时，背后多有不成功的男人");
		}else if(this.getAction().equals(PersonState1.FAILED)){
			System.out.println("女人失败时，眼泪汪汪，谁也劝不动");
		}else if(this.getAction().equals(PersonState1.LOVE)){
			System.out.println("女人恋爱时，遇到事情懂也装不懂");
		}
		
	}
	
}
class PersonState1{
	public final static String SUCCESS="SUCCESS";
	public final static String FAILED="FAILED";
	public final static String LOVE="LOVE";
}