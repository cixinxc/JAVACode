package com.cixin.learning.Code.Sort.ImplSort;

import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class QueckSort implements ISort {

	Data[] ds;
	
	public QueckSort() {
		
	}
	
	public QueckSort(Data[] ds) {
		this.ds = (Data[])ds.clone();  
	}
	
	public void showResult() {
		System.out.print("快速排序结果:"+"\n\t");
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

	public void sort(int left, int right) {
		if(left < right){
            Data key = this.ds[left];
            int low = left;
            int high = right;
            while(low < high) {
            	while(low < high && this.ds[high].getValue() > key.getValue()){
            		high--;
            	}
				if(low < high)
					this.ds[low++] = this.ds[high];
				while(low < high && this.ds[low].getValue() < key.getValue()){
					low++;
				}
				// 可能已经结束了, 赋值时候需要移位
				if(low < high)
					this.ds[high--] = this.ds[low];
            }
            this.ds[low] = key;
            sort(left,low-1);
            sort(low+1,right);
		}

	}
	
	public Data[] sort() {
		sort(0, this.ds.length-1);
		return getResult();
	}
	
	public Data[] sort(Data[] ds) {
		this.ds = (Data[])ds.clone();
		return sort();
	}

}

interface A{
	int b = 1;
	static void as(){int a = 0;}
}
abstract class AA {
	static int  a;
	{a = 2;}
	public static void as(){}
}