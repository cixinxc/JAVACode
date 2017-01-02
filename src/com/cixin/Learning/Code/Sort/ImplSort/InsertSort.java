package com.cixin.Learning.Code.Sort.ImplSort;

import com.cixin.Learning.Code.Sort.ISort.ISort;
import com.cixin.Learning.Model.Data;

public class InsertSort implements ISort {

	Data[] ds;
	
	public InsertSort() {
		
	}
	
	public InsertSort(Data[] ds) {
		this.ds = (Data[])ds.clone();  
	}
	
	public void showResult() {
		System.out.print("≤Â»Î≈≈–ÚΩ·π˚:"+"\n\t");
		int l = ds.length;
		for(int i = 0;i<l;i++) {
			System.out.print(""+ds[i].getKey()+":"+ds[i].getValue()+"	");
		}
		System.out.println("");
	}

	public Data[] getDs() {
		return ds;
	}

	public void setDs(Data[] ds) {
		this.ds = ds;
	}

	public Data[] getResult() {
		return (Data[])this.ds.clone();
	}

	public Data[] sort() {
		int length = this.ds.length;
		int i,j,k = 0;
		for(i=1;i<length;i++) {
			Data dv = ds[i];
			for(j=i-1;j>=0;j--) {
				if(dv.getValue()<ds[j].getValue()) {
					ds[j+1] = ds[j];	
				}
				else {
					break;
				}	
			} 
		//	System.out.println(dv.getValue());      
			ds[j+1] = dv;	
		}
		return getResult();
	}
	
	public Data[] sort(Data[] ds) {
		this.ds = (Data[])ds.clone(); 
		return sort();
	}
}
