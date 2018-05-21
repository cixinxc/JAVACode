package com.cixin.learning.Code.Sort.ImplSort;

import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class SelectSort implements ISort {

	Data[] ds;
	
	public SelectSort() {
		
	}
	
	public SelectSort(Data[] ds) {
		this.ds = (Data[])ds.clone();  
	}
	
	public void showResult() {
		System.out.print("Ñ¡ÔñÅÅÐò½á¹û:"+"\n\t");
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
		int i = 0,j = 0;
		int min = 0;
		for(i = 0;i<length;i++) {
			Data dv = this.ds[i];
			min = i;
			for(j = i+1;j<length;j++) {
				if(this.ds[min].getValue()>this.ds[j].getValue()) {
					min = j;
				}
			}
			this.ds[i] = this.ds[min];
			this.ds[min] = dv;
			
		}
		return getResult();
	}
	
	public Data[] sort(Data[] ds) {
		this.ds = (Data[])ds.clone(); 
		return sort();
	}
}
