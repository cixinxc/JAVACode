package com.cixin.DesignPatterns.Command;

public class CommandTwo extends Command{
	public CommandTwo(Reciever reciever) {
		super(reciever);
	}

	public void execute() {
		this.reciever.executeCommandTwo();
	}
}
