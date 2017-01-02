package com.cixin.DesignPatterns.Mediator;

public class RealMediator extends Mediator{

	public RealMediator(Person p1, Person p2) {
		super(p1, p2);
	}

	public void Media(Person p, String message) {
		p.getMessage(message);
	}

}
