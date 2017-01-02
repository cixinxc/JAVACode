package com.cixin.DesignPatterns.Composite;

public class Leaf extends Composite{

	private String name;
	
	public Leaf(String name) {
		this.name = name;
	}
	
	public void add(Composite composite) {
		this.composites.add(composite);
	}

	public void remove(Composite composite) {
		this.composites.remove(composite);
	}

	public void display() {
		System.out.print("\t");
		System.out.println(this.name);
	}

}
