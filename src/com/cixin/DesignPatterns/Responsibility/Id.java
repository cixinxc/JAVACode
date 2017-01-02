package com.cixin.DesignPatterns.Responsibility;

public class Id extends Self {

	public void decision(String thing, int level) {
		if("thing1".equals(thing) && level==1 )
		{
			System.out.println("可以");
		}
		else
		{
			System.out.println("交上一级处理");
			nextDecidor.decision(thing, level);
		}
	}
}
