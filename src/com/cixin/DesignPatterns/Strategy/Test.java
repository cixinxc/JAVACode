package com.cixin.DesignPatterns.Strategy;

public class Test {
	public static void main(String args[]) {
		StrategyFactory sf = new StrategyFactory();
		
		Params paramsStr = new Params("params");
		Params paramsInt = new Params(1);
		
		Strategy sInt = sf.productedStrategy("one");
		Strategy sStr = sf.productedStrategy("two");
		
		sStr.action(paramsStr);
		sInt.action(paramsInt);
		
	}
}
