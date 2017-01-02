package com.cixin.DesignPatterns.Command;

public class Text {
	public static void main(String args[]) {
		Reciever reciever = new Reciever();
		
		Command one = new CommandOne(reciever);
		Command two = new CommandTwo(reciever);
		
		Director director = new Director();
		director.addCommand(one);
		director.addCommand(two);
		director.notifys();
		
	}
}
