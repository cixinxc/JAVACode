package com.cixin.DesignPatterns.Strategy;

public class Params {
	private String paramStr;
	private int paramInt;
	
	public Params(String paramStr) {
		this.paramStr = paramStr;
	}
	
	public Params(int paramInt) {
		this.paramInt = paramInt;
	}
	
	public String getParamStr() {
		return paramStr;
	}
	public void setParamStr(String paramStr) {
		this.paramStr = paramStr;
	}
	public int getParamInt() {
		return paramInt;
	}
	public void setParamInt(int paramInt) {
		this.paramInt = paramInt;
	}
}
