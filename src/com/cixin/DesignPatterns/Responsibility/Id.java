package com.cixin.DesignPatterns.Responsibility;

public class Id extends Self {

	public void decision(String thing, int level) {
		if("thing1".equals(thing) && level==1 )
		{
			System.out.println("����");
		}
		else
		{
			System.out.println("����һ������");
			nextDecidor.decision(thing, level);
		}
	}
}
