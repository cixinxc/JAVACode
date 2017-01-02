package com.cixin.DesignPatterns.State;

public class Test {
	public static void main(String args[]) {
		System.out.println("״̬ģʽ");
		Context c = new Context(new Education());
		c.nextState();
		c.nextState();
		c.nextState();
	}
}
