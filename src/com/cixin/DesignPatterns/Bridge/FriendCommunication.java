package com.cixin.DesignPatterns.Bridge;

public class FriendCommunication implements Communication{

	public void talk() {
		System.out.println("talk as friends");
	}

	public void play() {
		System.out.println("play as friends");
	}

}
