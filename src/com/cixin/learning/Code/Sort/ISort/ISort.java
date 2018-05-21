package com.cixin.learning.Code.Sort.ISort;

import com.cixin.learning.Model.Data;

public interface ISort {
	public void showResult();
	public Object getResult();
	public Data[] sort();
	public Data[] sort(Data[] ds);	
}
