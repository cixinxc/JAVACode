package com.cixin.DesignPatterns.Bridge;

public class RefineAbstraction extends Abstraction{

	public void talk() {
		this.communication.talk();
	}
	public void play() {
		this.communication.play();
	}
}
