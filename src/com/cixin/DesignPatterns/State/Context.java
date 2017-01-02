package com.cixin.DesignPatterns.State;

public class Context {
	private States state;

	public Context(States state) {
		this.state = state;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		System.out.println(state.getClass());
		this.state = state;
	}
	public void nextState() {
		this.state.nextState(this);
	}
}
