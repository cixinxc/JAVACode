package com.cixin.DesignPatterns.Memento;

public class Memory {
	private String myLover;
	private String myHeart;
	
	public Memory() {
		this.myHeart = "";
		this.myLover = "";
	}
	
	
	public String getMyLover() {
		return myLover;
	}
	public void setMyLover(String myLover) {
		this.myLover = myLover;
	}
	public String getMyHeart() {
		return myHeart;
	}
	public void setMyHeart(String myHeart) {
		this.myHeart = myHeart;
	}
	
	public void loseLover() {
		this.myHeart = "";
	}
	
	public void talkMyLoverAndHeart() {
		System.out.println("I love "+this.myLover);
		System.out.println("There have  "+this.myHeart +" in my Heart");
	}
}
