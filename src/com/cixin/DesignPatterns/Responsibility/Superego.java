package com.cixin.DesignPatterns.Responsibility;

public class Superego extends Self {
	public void decision(String thing, int level) {
		if("thing1".equals(thing) && level==3 )
		{
			System.out.println("©ирт");
		}
		else
		{
			System.out.println("Ёад╛");
			return;
		//	nextDecidor.decision(thing, level);
		}
	}
}