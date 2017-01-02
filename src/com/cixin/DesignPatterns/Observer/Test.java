package com.cixin.DesignPatterns.Observer;

public class Test {
	public static void main(String args[]) {
		Observer observer = new Sentry();
		
		Student s1 = new Student("张三", "玩手机");
		Student s2 = new Student("李四", "看小说");
		Student s3 = new Student("王五", "聊天");
		Student s4 = new Student("崔七", "睡觉");
		
		observer.addStudeng(s1);
		observer.addStudeng(s2);
		
		System.out.println("观察者notify之前:");
		s1.showStatus();
		s2.showStatus();
		s3.showStatus();
		s4.showStatus();
		
		observer.notifys();
		
		System.out.println("观察者notify之后:");
		s1.showStatus();
		s2.showStatus();
		s3.showStatus();
		s4.showStatus();
	}
}
