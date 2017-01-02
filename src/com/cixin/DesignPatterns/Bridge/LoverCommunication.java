package com.cixin.DesignPatterns.Bridge;

public class LoverCommunication implements Communication{

	public void talk() {
		System.out.println("talk as lover");
	}

	public void play() {
		System.out.println("play as lover");
	}

}
