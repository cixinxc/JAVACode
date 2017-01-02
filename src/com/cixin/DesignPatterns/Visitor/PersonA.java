package com.cixin.DesignPatterns.Visitor;

public class PersonA extends Person {

	public void visitA() {
		System.out.println("PersonA' visitA");
	}

	public void visitB() {
		System.out.println("PersonA' visitB");
	}

}
