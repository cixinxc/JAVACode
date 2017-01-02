package com.cixin.DesignPatterns.Mediator;

public abstract class Person {
	protected String name;
	public Person(String name) {
		this.name = name;
	}
	public abstract void getMessage(String message);
}
