package com.cixin.Learning.Common;

import com.cixin.Learning.Model.Data;

public class Common {
	
	private Common() {
		
	}
	
	public static void exchange(Data d1, Data d2) {
		Data d = d1;
		d1 = d2;
		d2 = d;
	}
	
	public static Data[] getDataArray(int length) {
		Data[] dataset = new Data[length];
		for(int i = 0; i<length; i++) {
			dataset[i] = new Data(i, (int)(Math.random()*100));
		}
		
		return dataset;
	}
}
