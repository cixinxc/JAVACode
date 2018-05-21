package com.cixin.learning.Code.Sort.ImplSort;

import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class BubbleSort implements ISort {
	Data[] ds;
	
	public BubbleSort() {
		
	}
	
	public BubbleSort(Data[] dss) {
		this.ds = (Data[])dss.clone();  
	}
	
	public void showResult() {
		System.out.print("Ã°ÅÝÅÅÐò½á¹û:"+"\n\t");
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
		
		for(int i=0;i<length;i++) {
			for(int j=i;j<length;j++) {
				if(ds[i].getValue()>ds[j].getValue()) {
					Data d = ds[i];
					ds[i] = ds[j];
					ds[j] = d;
				}
			}            
		}
		
		return getResult();
	}
	
	public Data[] sort(Data[] ds) {
		this.ds = (Data[])ds.clone(); 
		return sort();
	}
}
