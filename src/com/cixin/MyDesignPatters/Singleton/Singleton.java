package com.cixin.MyDesignPatters.Singleton;

public class Singleton {
	private static Singleton singleton = null;
	private Singleton() {
	}
	
	public static synchronized Singleton getSingleton() {
		if( singleton == null ) {
			singleton = new Singleton();
		}
		return singleton;
	}
}
