package com.cixin.DesignPatterns.Mediator;

public class Friends extends Person{

	public Friends(String name) {
		super(name);
	}

	public void getMessage(String message) {
		System.out.println(this.name+"Ω” ’µΩ:"+message);
	}
}
