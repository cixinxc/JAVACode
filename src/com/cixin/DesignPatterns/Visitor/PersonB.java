package com.cixin.DesignPatterns.Visitor;

public class PersonB extends Person {
	public void visitA() {
		System.out.println("PersonB' visitA");
	}

	public void visitB() {
		System.out.println("PersonB' visitB");
	}
}
