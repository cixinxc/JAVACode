package com.cixin.DesignPatterns.Iterator;

public class Test {
	public static void main(String args[]) {
		Iter it = new Iter();
		it.setO("a");
		Iter it2 = new Iter();
		it2.setO("a1");
		
		Iter it3 = new Iter();
		it3.setO("a2");
		Iter it4 = new Iter();
		it4.setO("a3");
		Iter it5 = new Iter(it3);
		
		
		Iterator ii = new Iterator();
		ii.add(it);
	//	System.out.println(ii.next());
		ii.add(it2);
	//	System.out.println(ii.next());
		ii.add(it3);
	//	System.out.println(ii.next());
		ii.add(it4);
	//	System.out.println(ii.next());
		ii.add(it5);
		ii.setL(0);
		
		System.out.println("			长度	"+ii.getLength());
		System.out.println("			长度   "+ii.getIter().getO());
		System.out.println("			长度   "+ii.getIter().getNext().getO());
		System.out.println("			长度   "+ii.getIter().getNext().getNext().getO());
		System.out.println("			长度   "+ii.getIter().getNext().getNext().getNext().getO());
	//	System.out.println("长度"+it.getNext().getO());
		System.out.println(ii.next());
		System.out.println(ii.next());
		System.out.println(ii.next());
		System.out.println(ii.next());
		
		Iter itn1 = new Iter();
		itn1.setO(1);
		Iter itn = new Iter();
		System.out.println("Iter itn = itn1;	"+itn1.getO()+"		"+"   "+itn+"   "+itn1);
		itn= itn1;
		System.out.println("Iter itn = itn1;	"+itn1.getO()+"		"+itn.getO()+"   "+itn+"   "+itn1);
		itn.setO(2);
		System.out.println("itn.setO(2);		"+itn1.getO()+"		"+itn.getO()+"   "+itn+"   "+itn1);
		Iter itn3 = new Iter();
		itn3.setO(3);
		itn1 = itn3;
		System.out.println("itn = itn3;		"+itn1.getO()+"		"+itn.getO()+"   "+itn1+"   "+itn3);
	}
}
