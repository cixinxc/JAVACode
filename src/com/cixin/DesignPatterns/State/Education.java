package com.cixin.DesignPatterns.State;

public class Education extends States{
	public void nextState(Context context) {
		context.setState(new Marry());
	}

}
