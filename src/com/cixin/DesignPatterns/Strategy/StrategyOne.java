package com.cixin.DesignPatterns.Strategy;

public class StrategyOne implements Strategy{

	public void action(Params params) {
		System.out.println("params:"+params.getParamInt());
		System.out.println("talk strategy One");
	}

}
