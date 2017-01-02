package com.cixin.DesignPatterns.Factory;

class sendA implements send{
	public void send() {
		System.out.println("A");
	}
}

class sendB implements send{
	public void send() {
		System.out.println("B");
	}
}

interface send {
	public void send();
}
interface Factorys {
	public send produce();
}

class AFactorys implements Factorys {
	public send produce() {
		return new sendA();
	}
}

class BFactorys implements Factorys {
	public send produce() {
		return new sendB();
	}
}

class Factory {
	public send produce(String type) {
		if(type.equals("A"))
			return new sendA();
		else if(type.equals("B"))	
			return new sendB();
		else
			return null;
	}
	
	public send sendA() {
		return new sendA();
	}
	public send sendB() {
		return new sendB();
	}
	public static send sendA2() {
		return new sendA();
	}
	public static send sendB2() {
		return new sendB();
	}
}



public class Factoryss {
	public static void  main(String[] args){
		Factory f = new Factory();
		
		send a = f.produce("A"); a.send();
		send b = f.produce("B"); b.send();
		/*工厂方法*/
		send a2 = f.sendA(); 	 a2.send();
		send b2 = f.sendB(); 	 b2.send();
		Factorys af = new AFactorys(); af.produce().send();
		Factorys bf = new BFactorys(); bf.produce().send();
		/*静态工厂*/
		Factory.sendA2().send();
	}
}
