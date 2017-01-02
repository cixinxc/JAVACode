package com.cixin.DesignPatterns.Faced;

public class Facade {
	private MethodOne one ;
	private MethodTwo two;
	private MethodThree three;
	public Facade() {
		one = new MethodOne();
		two = new MethodTwo();
		three = new MethodThree();
	}
	public void solveQuestionOne() {
		one.method();
		two.method();
	}
	public void solveQuestionTwo() {
		three.method();
		one.method();
	}
}
