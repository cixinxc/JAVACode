package com.cixin.DesignPatterns.Decoration;

public class Tshirt extends Decoration{
	public Tshirt(Person person) {
		super(person);
	}

	public void show() {
		System.out.print("Tshirt ");
		super.show();
	}
}
