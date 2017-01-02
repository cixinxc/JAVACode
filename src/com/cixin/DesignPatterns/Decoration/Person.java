package com.cixin.DesignPatterns.Decoration;

public class Person {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person()
	{}
	public Person(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println(" Decoration " + this.name);
	}
	
}
