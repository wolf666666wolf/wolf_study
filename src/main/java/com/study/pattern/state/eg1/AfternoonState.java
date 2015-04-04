package com.study.pattern.state.eg1;

public class AfternoonState implements State{
	@Override
	public void writeProgram(Work work) {
		if(work.getHour()>14 && work.getHour()<18){
			System.out.println("当前时间：" + work.getHour() +" 下午时间，还要工作！");
		}else{
			work.setState(new EveningState());
			work.writeProgram();
		}
	}
}
