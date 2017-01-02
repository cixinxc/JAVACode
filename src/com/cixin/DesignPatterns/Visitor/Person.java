package com.cixin.DesignPatterns.Visitor;

public abstract class Person {
	protected String name;
	public abstract void visitA();
	public abstract void visitB();
}
