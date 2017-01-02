package com.cixin.DesignPatterns.Observer;

public class Test {
	public static void main(String args[]) {
		Observer observer = new Sentry();
		
		Student s1 = new Student("����", "���ֻ�");
		Student s2 = new Student("����", "��С˵");
		Student s3 = new Student("����", "����");
		Student s4 = new Student("����", "˯��");
		
		observer.addStudeng(s1);
		observer.addStudeng(s2);
		
		System.out.println("�۲���notify֮ǰ:");
		s1.showStatus();
		s2.showStatus();
		s3.showStatus();
		s4.showStatus();
		
		observer.notifys();
		
		System.out.println("�۲���notify֮��:");
		s1.showStatus();
		s2.showStatus();
		s3.showStatus();
		s4.showStatus();
	}
}
