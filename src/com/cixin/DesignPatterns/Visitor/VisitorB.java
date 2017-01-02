package com.cixin.DesignPatterns.Visitor;

public class VisitorB extends Visitor{

	public void visitA(Person p) {
		System.out.println(p.toString()+"	Person' visitA");
	}

	public void visitB(Person p) {
		System.out.println(p.toString()+"	Person' visitB");
	}
	
}
