package com.study.pattern.state.eg1;

public class BadClass {

}

class Work1{
	private int hour;
	private boolean finished;

	public void wirteProgram(){
		if(hour<12){
			System.out.println("当前时间：" + hour +" 上午时间，精神百倍！");
		}else if(hour>12 && hour<14){
			System.out.println("当前时间：" + hour +" 午餐时间，打个盹！");
		}else if(hour>14 && hour<18){
			System.out.println("当前时间：" + hour +" 下午时间，还要工作！");
		}else{
			if(finished){
				System.out.println("当前时间：" + hour +" 下班了，回家！");
			}else if(hour<22){
				System.out.println("当前时间：" + hour +" 要命啊，还在加班！");
			}else{
				System.out.println("当前时间：" + hour +" 睡着了！");
			}
			
		}
		
	}
	
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
}
