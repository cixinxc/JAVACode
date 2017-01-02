package com.cixin.DesignPatterns.Mediator;

public abstract class Mediator {
	protected Person p1;
	protected Person p2;
	
	public Mediator(Person p1, Person p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public abstract void Media(Person p ,String message);
}
