package com.cixin.DesignPatterns.State;

public class Marry extends States {
	public void nextState(Context context) {
		context.setState(new Death());
	}

}
