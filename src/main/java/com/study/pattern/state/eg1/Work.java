package com.study.pattern.state.eg1;
/**
 * 状态模式将与特定状态相关的行为局部化，并将不同状态的行为分割开来
 * 当一个对象的行为取决于他的状态并且他必须在运行时改变他的行为，就可以考虑状态模式了
 * @author BULL
 *
 */
public class Work {
	private int hour;
	private State current;
	private boolean finsished = false;
	
	public Work(){
		current = new MorningState();
	}
	public void setState(State current) {
		this.current = current;
	}
	
	public void writeProgram(){
		current.writeProgram(this);
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}


	public boolean getFinsished() {
		return finsished;
	}
	public void setFinsished(boolean finsished) {
		this.finsished = finsished;
	}
	
	public static void main(String[] args){
		Work work = new Work();
		work.setHour(9);
		work.writeProgram();
		work.setHour(13);
		work.writeProgram();
		work.setHour(15);
		work.writeProgram();	
		
		System.out.println("==============");
		work.setFinsished(true);
		work.setHour(19);
		work.writeProgram();
		work.setHour(23);
		work.writeProgram();
		
	}
}
