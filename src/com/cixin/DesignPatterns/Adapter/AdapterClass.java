package com.cixin.DesignPatterns.Adapter;

public class AdapterClass implements Adapter{
	private OldClass oc = new OldClass();
	public void adapter() {
		System.out.println("ÊÊÅäºóµÄshow()");
		oc.show();
	}
}
