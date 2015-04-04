package com.study.pattern.command.eg1;

public class ChickenWingCommand extends Command{

	public ChickenWingCommand(Barbecuer barbecuer) {
		super(barbecuer);
	}

	@Override
	public void executeCommand() {
		this.barbecuer.bakeChickenWing();
	}
	@Override
	public String toString(){
		return "烤鸡翅";
	}
}
