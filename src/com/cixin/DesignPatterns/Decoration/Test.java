package com.cixin.DesignPatterns.Decoration;

public class Test {
	public static void main(String[] args) {
		System.out.println("ÐÞÊÎÆ÷Ä£Ê½");
		
		Person p = new Person("cuixinxin");
		Decoration d = new Decoration(p);
		d.show();
		
		Tshirt t = new Tshirt(p);
		Hat h = new Hat(t);
		h.show();
		
		
	}
}
