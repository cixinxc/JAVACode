package com.cixin.DesignPatterns.Visitor;

public class Test {
	public static void main(String args[]) {
		Person a = new PersonA();
		Person b = new PersonB();
		
		Visitor av = new VisitorA();
		Visitor bv = new VisitorB();
		
		av.visitA(a);
		av.visitB(a);
		av.visitA(b);
		av.visitB(b);
		
		bv.visitA(a);
		bv.visitB(a);
		bv.visitA(b);
		bv.visitB(b);
	}
}
