package com.cixin.learning.Code.Sort.ImplSort;

import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class MergeSort implements ISort {
	Data[] ds;
	
	public MergeSort() {
		
	}
	
	public MergeSort(Data[] ds) {
		setDs(ds); 
	}
	
	public void showResult() {
		System.out.print("归并排序结果:"+"\n\t");
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
		this.ds = (Data[])ds.clone();
	}

	public Data[] getResult() {
		return (Data[])this.ds.clone();
	}

	public Data[] sort() {
		int data_length = this.ds.length;
		
		for(int i = 1; i<data_length*2; i*=2) {
			for(int j = 0; j<data_length; j+=i) {
				Data[] sortData = new Data[(j+i<data_length)?i:(data_length-j)];
			//	System.out.println("   sortData  "+((j+i<data_length)?i:(data_length-j)));
				for(int k = j; k<j+i && k<data_length; k++) {
					sortData[k-j] = this.ds[k];
				}
				sortData = new BubbleSort(sortData).sort();
				for(int k = j; k<j+i && k<data_length; k++) {
					this.ds[k] = sortData[k-j];
				}
			//	System.out.println("   sortData  "+sortData.length);
				/*
				System.out.println("排序结果       :");
				for(int ii = 0;ii<i;ii++) {
					System.out.print(""+sortData[ii].getKey()+":"+sortData[ii].getValue()+"	");
				}
				System.out.println("");
				*/
			}
		//	this.showResult();
		}
		
		return getResult();
	}
	
	public Data[] sort(Data[] ds) {
		this.ds = (Data[])ds.clone(); 
		return sort();
	}
}
