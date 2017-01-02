package com.cixin.DesignPatterns.Memento;

public class Test {
	public static void main(String args[]) {
		Memento mo = new Memento();
		Memory memory = new Memory();
		
		memory.setMyLover("Wang");
		memory.setMyHeart(" 'love' Wang");
		mo.saveMemory(memory);
		
		memory.talkMyLoverAndHeart();
		memory.loseLover();
		memory.talkMyLoverAndHeart();
		memory = mo.loadMemory();
		memory.talkMyLoverAndHeart();
		
	}
}
