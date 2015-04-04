package com.study.pattern.command.eg1;

public class MuttonCommand extends Command{
	
	public MuttonCommand(Barbecuer barbecuer) {
		super(barbecuer);
	}

	@Override
	public void executeCommand() {
		this.barbecuer.bakeMutton();		
	}
	@Override
	public String toString(){
		return "烤羊肉串";
	}
}
