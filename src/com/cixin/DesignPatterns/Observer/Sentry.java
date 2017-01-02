package com.cixin.DesignPatterns.Observer;

public class Sentry extends Observer{

	public void notifys() {
		for( Student student:this.students) {
			student.setStatus("ѧϰ");
		}
	}

}
