package com.cixin.DesignPatterns.Decoration;

public class Hat extends Decoration{
	public Hat(Person person) {
		super(person);
	}

	public void show() {
		System.out.print("hat ");
		super.show();
	}
}
