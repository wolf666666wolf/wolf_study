package com.study.pattern.state.eg1;

public class MorningState implements State{
	@Override
	public void writeProgram(Work work) {
		if(work.getHour()<12){
			System.out.println("当前时间：" + work.getHour() +" 上午时间，精神百倍！");
		}else{
			work.setState(new NoonState());
			work.writeProgram();
		}
	}

}
