package com.cixin.DesignPatterns.TemplateMethed;

public abstract class Template {
	public abstract void methodOne();
	public abstract void methodTwo();
	
	public void mainMethod() {
		System.out.println("ִ����������");
		methodOne();
		methodTwo();
	}
}
