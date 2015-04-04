package com.study.pattern.command.eg1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Waiter {
	public List<Command> cmdList = new ArrayList<Command>();
	public void addCommand(Command cmd){
		cmdList.add(cmd);
		System.out.println("增加订单："+cmd.toString()+"   时间："+new Date());
	}
	public void cancelCommand(Command cmd){
		cmdList.remove(cmd);
	}
	
	public void commit(){
		for(Command cmd: cmdList){
			cmd.executeCommand();
		}
	}
	
	
}
