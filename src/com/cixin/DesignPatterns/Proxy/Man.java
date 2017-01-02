package com.cixin.DesignPatterns.Proxy;

public class Man implements GiveGift{

	private Girl myLover;
	
	public Man(Girl girl) {
		this.myLover = girl;
	}
	
	public void giveFlower() {
		System.out.println("give " + myLover.getName() + " flowers");
	}

	public void giveFood() {
		System.out.println("give " + myLover.getName() + " foods");
	}

	public void giveMyHeart() {
		System.out.println("give " + myLover.getName() + " my Heart");
	}

}
