package com.cixin.learning.Code.Sort.ImplSort;

import java.util.ArrayList;
import java.util.List;

import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class ShellSort implements ISort{

	Data[] ds;
	private int [] shell = {10,5,3,1};
	
	public ShellSort() {
		
	}
	
	public ShellSort(Data[] ds) {
		setDs(ds); 
	}
	
	public void showResult() {
		System.out.print("Ï£¶ûÅÅÐò½á¹û:"+"\n\t");
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
		/*
		int length = 0;
		for(int count = ds.length;count>=1;length++, count /= 2)
			length++;
		int[] new_shell = new int[length];
		for(int i = 0;length>=0; length--)
			new_shell[i] = ;
		*/
	}

	public Data[] getResult() {
		return (Data[])this.ds.clone();
	}

	public Data[] sort() {
		int data_length = this.ds.length;
		int shell_length = this.shell.length;
		for(int i = 0; i<shell_length; i++) {
		//	for(int j = 0; j<this.shell[i] && j<data_length; j++) {
			for(int j = 0; j<this.shell[i]; j++) {
			List<Data> sortData = new ArrayList<Data>();
				for(int k = j; k<data_length; k+=this.shell[i]) {
					sortData.add(this.ds[k]);
				}
				Data[] sortedData = new Data[sortData.size()];
				for(int m = 0; m<sortData.size(); m++) {
					sortedData[m] = sortData.get(m);
				}
				sortedData = new BubbleSort(sortedData).sort();
				for(int k = j, m = 0; k<data_length; k+=this.shell[i], m++) {
					this.ds[k] = sortedData[m];
				}
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
