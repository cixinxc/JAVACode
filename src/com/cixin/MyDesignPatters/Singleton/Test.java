package com.cixin.MyDesignPatters.Singleton;

class MyThread implements Runnable {
	private Singleton singleton = Singleton.getSingleton();

	public void run() {
		for(int i = 0;i<10000;i++)
			for(int i2 = 0;i2<1;i2++)
				System.out.println("singleton:	"+Singleton.getSingleton().toString());
				//System.out.println("singleton:	"+singleton);
	}
}

public class Test {
	public static void main(String[] args) {
	//	Singleton singleton1 = Singleton.getSingleton();
	//	Singleton singleton2 = Singleton.getSingleton();
		
	//	System.out.println("singleton1:	"+singleton1.toString());
	//	System.out.println("singleton2:	"+singleton2.toString());
		
		for(int i = 0;i<100;i++)
			new MyThread().run();
		
	}
}
