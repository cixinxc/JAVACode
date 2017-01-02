package com.cixin.DesignPatterns.Strategy;

public class StrategyFactory {
	public Strategy productedStrategy(String type) {
		Strategy strategy = null;
		if(type.equals("one")) {
			strategy = new StrategyOne();
		}
		else if(type.equals("two")) {
			strategy = new StrategyTwo();
		}
		return strategy;
	}
}
