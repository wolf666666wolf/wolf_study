package com.study.pattern.state.eg1;

public class NoonState implements State{
	@Override
	public void writeProgram(Work work) {
		if(work.getHour()>=12 && work.getHour()<14){
			System.out.println("当前时间：" + work.getHour() +" 午餐时间，打个盹！");
		}else{
			work.setState(new AfternoonState());
			work.writeProgram();
		}
	}
}
