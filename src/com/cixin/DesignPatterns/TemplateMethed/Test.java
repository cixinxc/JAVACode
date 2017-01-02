package com.cixin.DesignPatterns.TemplateMethed;

public class Test {
	public static void main(String args[]) {
		Template learnMath = new TemplateLearnMath();
		Template learnEnglish = new TemplateLearnEnglish();
		
		learnMath.mainMethod();
		learnEnglish.mainMethod();;
	}
}
