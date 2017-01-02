package com.cixin.DesignPatterns.Proxy;

public class Friend implements GiveGift{

	private Man man;
	
	public Friend(Man man) {
		this.man = man;
	}
	
	public void giveFlower() {
		man.giveFlower();
	}

	public void giveFood() {
		man.giveFood();
	}

	public void giveMyHeart() {
		man.giveMyHeart();
	}
}
