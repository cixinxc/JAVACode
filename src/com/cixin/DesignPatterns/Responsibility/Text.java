package com.cixin.DesignPatterns.Responsibility;

public class Text {
	public static void main(String args[]) {
		Self id = new Id();
		Self ego = new Ego();
		Self superego = new Superego();
		id.setnextDecidor(ego);
		ego.setnextDecidor(superego);
		
		id.decision("thing1", 4);
	}
}
