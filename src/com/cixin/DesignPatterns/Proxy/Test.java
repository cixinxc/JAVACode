package com.cixin.DesignPatterns.Proxy;

public class Test {
	public static void main(String args[]) {
		System.out.println("代理模式");
		
		Girl girl = new Girl("ling er");
		
		Man man = new Man(girl); 
		Friend friend = new Friend(man);
		friend.giveFlower();
		friend.giveFood();
		friend.giveMyHeart();
	}
}
