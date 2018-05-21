package com.cixin.learning.Code.Test;

import com.cixin.learning.Code.Sort.ImplSort.*;
import com.cixin.learning.Common.Common;
import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class SortTest {
	public static void main(String args[]) {
		// 获得待排序数据
		Data[] dataset = Common.getDataArray(15);
		/*
		// 冒泡
		ISort bubbleSort = new BubbleSort(dataset);
		bubbleSort.sort();
		bubbleSort.showResult();

		// 快速
		ISort insertSort = new InsertSort(dataset);
		insertSort.sort();
		insertSort.showResult();
		// 选择
		ISort selectSort = new SelectSort(dataset);
		selectSort.sort();
		selectSort.showResult();
		// 快速
		ISort queckSort = new QueckSort(dataset);
		queckSort.sort();
		queckSort.showResult();
		// 希尔
		ISort shellSort = new ShellSort(dataset);
		shellSort.sort();
		shellSort.showResult();
		*/
		// 归并
		ISort mergeSort = new MergeSort(dataset);
		mergeSort.sort();
		mergeSort.showResult();
	}
}
