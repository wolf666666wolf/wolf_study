package com.study.pattern.state.eg1;

public class EveningState implements State{
	@Override
	public void writeProgram(Work work) {
		if(work.getFinsished()){
			System.out.println("当前时间：" + work.getHour() +" 工作完成，下班了！");
		}else{
			if(work.getHour()<22){
				System.out.println("当前时间：" + work.getHour() +" 加班中！");	
			}else{
				work.setState(new SleepingState());
				work.writeProgram();				
			}
		}
	}
}
