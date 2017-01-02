package com.cixin.DesignPatterns.State;

public class Death extends States {
	public void nextState(Context context) {
		context.setState(new Death());
	}
}
