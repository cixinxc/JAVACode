package com.cixin.DesignPatterns.Responsibility;

public class Superego extends Self {
	public void decision(String thing, int level) {
		if("thing1".equals(thing) && level==3 )
		{
			System.out.println("����");
		}
		else
		{
			System.out.println("��Ĭ");
			return;
		//	nextDecidor.decision(thing, level);
		}
	}
}