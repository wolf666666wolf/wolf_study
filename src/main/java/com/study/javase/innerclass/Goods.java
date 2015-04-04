package com.study.javase.innerclass;

interface Contents {   
	int value();   
}   
	  
interface Destination {   
	String readLabel();   
}   
	  
public class Goods {
	private class Content implements Contents{
		private int i = 11;
		public int value() {
			return i;
		}		
	}
	protected class GDestination implements Destination{
		private String label;
		public GDestination(String toWhere){
			this.label = toWhere;
		}
		public String readLabel() {
			System.out.println(label);
			return label;
		}
	}
	public Destination dest(String dest){
		return new GDestination(dest);
	}
	public Contents cont(){
		return new Content();
	}
	
	public static void main(String[] args){
		Goods g = new Goods();
		Contents content= g.cont();
		Destination dest = g.dest("BeiJing");
		dest.readLabel();
		
		g.new Content();
		g.new GDestination("");
	}
}

