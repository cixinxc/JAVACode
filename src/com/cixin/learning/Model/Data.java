package com.cixin.learning.Model;

public class Data {
	private int value;
	private int key;
	private int type = 0;
	
	public Data() {
		
	}
	
	public Data(int key, int value) {
		this.key = key;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
