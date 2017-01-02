package com.cixin.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observer {
	protected List<Student> students = new ArrayList<Student>();
	
	public void addStudeng(Student student) {
		students.add(student);
	}
	
	public abstract void notifys();
}
