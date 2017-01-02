package com.cixin.DesignPatterns.Mediator;

public class Self extends Person{

	public Self(String name) {
		super(name);
	}

	public void getMessage(String message) {
		System.out.println(this.name+"Ω” ’µΩ:"+message);
	}

}
