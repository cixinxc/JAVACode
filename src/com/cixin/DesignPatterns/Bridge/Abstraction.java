package com.cixin.DesignPatterns.Bridge;

public  class Abstraction {
	protected Communication communication;

	public Communication getCommunication() {
		return communication;
	}

	public void setCommunication(Communication communication) {
		this.communication = communication;
	}
	public void operate()
	{
		this.communication.talk();
		this.communication.play();
	}
	
}
