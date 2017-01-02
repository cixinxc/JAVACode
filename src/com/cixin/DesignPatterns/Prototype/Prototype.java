package com.cixin.DesignPatterns.Prototype;

public abstract class Prototype {
	private String name;
	private String mylover;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMylover() {
		return mylover;
	}

	public void setMylover(String mylover) {
		this.mylover = mylover;
	}

	public abstract void clones();
}
