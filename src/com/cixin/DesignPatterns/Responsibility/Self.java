package com.cixin.DesignPatterns.Responsibility;

public abstract class Self {
	protected Self nextDecidor;
	public void setnextDecidor(Self nextDecidor) {
		this.nextDecidor = nextDecidor;
	}
	public abstract void decision(String thing, int level);
}
