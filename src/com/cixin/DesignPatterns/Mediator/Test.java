package com.cixin.DesignPatterns.Mediator;

public class Test {
	public static void main(String args[]) {
		Person s = new Self("s");
		Person f = new Friends("f");
		Mediator rm = new RealMediator(s,f);
		rm.Media(s, "f������Ϣ��");
		rm.Media(f, "s������Ϣ��");
	}
}
