package com.cixin.DesignPatterns.Builder;

public class Director {
	public void build(Builder builder) {
		builder.completionStageOne();
		builder.completionStagetwo();
	}
}
