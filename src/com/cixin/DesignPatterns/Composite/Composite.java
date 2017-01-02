package com.cixin.DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite {
	protected List<Composite> composites = new ArrayList<Composite>();
	
	public abstract void add(Composite composite);
	public abstract void remove(Composite composite);
	public abstract void display();
}
