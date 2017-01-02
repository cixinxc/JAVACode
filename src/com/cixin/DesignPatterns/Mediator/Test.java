package com.cixin.DesignPatterns.Mediator;

public class Test {
	public static void main(String args[]) {
		Person s = new Self("s");
		Person f = new Friends("f");
		Mediator rm = new RealMediator(s,f);
		rm.Media(s, "f发来消息。");
		rm.Media(f, "s发来消息。");
	}
}
