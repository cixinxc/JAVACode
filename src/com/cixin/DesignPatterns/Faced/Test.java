package com.cixin.DesignPatterns.Faced;

public class Test {
	public static void main(String args[]) {
		Facade f = new Facade();
		System.out.println("问题1的解决方法:");
		f.solveQuestionOne();
		System.out.println("问题2的解决方法:");
		f.solveQuestionTwo();
	}
}
