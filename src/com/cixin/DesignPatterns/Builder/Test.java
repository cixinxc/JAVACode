package com.cixin.DesignPatterns.Builder;

public class Test {
	public static void main(String args[]) {
		Director d = new Director();
		
		Educated e = new Educated();
		Marred m = new Marred();
		d.build(e);
		d.build(m);
	}
}
