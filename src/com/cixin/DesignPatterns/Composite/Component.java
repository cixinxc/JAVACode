package com.cixin.DesignPatterns.Composite;

public class Component extends Composite{
	
	private String name;
	
	public Component(String name) {
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
		for(Composite composite:this.composites) {
			composite.display();
		}
	}
}
