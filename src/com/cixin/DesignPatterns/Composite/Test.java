package com.cixin.DesignPatterns.Composite;

public class Test {
	public static void main(String args[]) {
		Composite root = new Component("root");
		Composite root1 = new Component("roo1t");
		Composite root2 = new Component("root2");
		Composite root3 = new Component("root3");
		
		Composite leaf1 = new Leaf("leaf1");
		Composite leaf2 = new Leaf("leaf2");
		Composite leaf3 = new Leaf("leaf3");
		Composite leaf4 = new Leaf("leaf4");
		
		root.add(leaf4);
		root.add(root1);
		root.add(leaf1);
		root1.add(root2);
		root2.add(root3);
		root3.add(leaf2);
		root3.add(leaf3);
		
		root.display();
	}
}
