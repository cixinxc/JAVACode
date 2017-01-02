package com.cixin.DesignPatterns.Bridge;

public class Test {
	public static void main(String args[]) {
		FriendCommunication f = new FriendCommunication();
		LoverCommunication l = new LoverCommunication();
		
		RefineAbstraction ra = new RefineAbstraction();
		
		ra.setCommunication(f);
		ra.talk();
		ra.play();
		
		ra.setCommunication(l);
		ra.talk();
		ra.play();
		
		Abstraction a = new Abstraction();
		a.setCommunication(f);
		a.operate();
	}
}
