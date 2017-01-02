package com.cixin.DesignPatterns.Strategy;

public class StrategyTwo implements Strategy{

	public void action(Params params) {
		System.out.println("params:"+params.getParamStr());
		System.out.println("take strategy Two");
	}
	
}
