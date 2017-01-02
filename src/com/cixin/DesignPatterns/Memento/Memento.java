package com.cixin.DesignPatterns.Memento;

public class Memento {
	private Memory memory = new Memory();
	
	public Memory getMemory() {
		return memory;
	}
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	public void saveMemory(Memory memory) {
		//实际中可能只需要保存memory一部分信息
	//	this.memory = memory;
		this.memory.setMyHeart(memory.getMyHeart());
		this.memory.setMyLover(memory.getMyLover());
	}
	public Memory loadMemory() {
		return memory;
	}
}
