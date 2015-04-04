package com.study.pattern.state.eg1;

public class SleepingState implements State{
	@Override
	public void writeProgram(Work work) {
		if(work.getHour()>=22){
			System.out.println("当前时间：" + work.getHour() +" 睡着了！");
		}else{
			work.setState(new SleepingState());
			work.writeProgram();
		}
	}
}
