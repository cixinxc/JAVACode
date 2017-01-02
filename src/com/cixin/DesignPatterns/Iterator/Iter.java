package com.cixin.DesignPatterns.Iterator;

public class Iter {
	private Object o;
	private Iter iter;
	private Iter next;
	
	public Iter() {
		this.o = null;
		this.iter = null;
		this.next = null;
	}
	
	public Iter(Iter iter) {
//		this.setIter(iter.getIter());
//		this.setNext(iter.getNext());
//		this.setO(iter.getO());
		this.o = iter.getO();
		this.iter = iter;
		this.next = iter.getNext();
	}
	
	public void nextIs(Iter next) {
		this.next = next;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	public Iter getIter() {
		return iter;
	}

	public void setIter(Iter iter) {
		this.iter = iter;
	}

	public Iter getNext() {
		return next;
	}

	public void setNext(Iter next) {
		this.next = next;
	}
	
}
