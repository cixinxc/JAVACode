package com.cixin.DesignPatterns.Command;

import java.util.ArrayList;
import java.util.List;

public class Director {
	private List<Command> command = new ArrayList<Command>();
	public void addCommand(Command command) {
		this.command.add(command);
	}
	public void notifys() {
		for(Command c:command)  
        {  
            c.execute();
        }  
	}
}
