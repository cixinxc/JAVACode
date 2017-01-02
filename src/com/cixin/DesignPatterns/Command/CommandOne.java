package com.cixin.DesignPatterns.Command;

public class CommandOne extends Command{
	
	public CommandOne(Reciever reciever) {
		super(reciever);
	}

	public void execute() {
		this.reciever.executeCommandOne();
	}

}
