package com.cixin.DesignPatterns.Decoration;
//Decorator
public class Decoration extends Person{
	protected Person person;
	public Decoration(Person person) {
		this.person = person;
	}
	public void show()
	{
		if(person != null)
			person.show();
	}
}
