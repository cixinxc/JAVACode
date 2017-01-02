package com.cixin.Learning.Code.Sort.ISort;

import com.cixin.Learning.Model.Data;

public interface ISort {
	public void showResult();
	public Object getResult();
	public Data[] sort();
	public Data[] sort(Data[] ds);	
}
