package com.cixin.learning.Code.Test;

import com.cixin.learning.Code.Sort.ImplSort.*;
import com.cixin.learning.Common.Common;
import com.cixin.learning.Code.Sort.ISort.ISort;
import com.cixin.learning.Model.Data;

public class SortTest {
	public static void main(String args[]) {
		// ��ô���������
		Data[] dataset = Common.getDataArray(15);
		/*
		// ð��
		ISort bubbleSort = new BubbleSort(dataset);
		bubbleSort.sort();
		bubbleSort.showResult();

		// ����
		ISort insertSort = new InsertSort(dataset);
		insertSort.sort();
		insertSort.showResult();
		// ѡ��
		ISort selectSort = new SelectSort(dataset);
		selectSort.sort();
		selectSort.showResult();
		// ����
		ISort queckSort = new QueckSort(dataset);
		queckSort.sort();
		queckSort.showResult();
		// ϣ��
		ISort shellSort = new ShellSort(dataset);
		shellSort.sort();
		shellSort.showResult();
		*/
		// �鲢
		ISort mergeSort = new MergeSort(dataset);
		mergeSort.sort();
		mergeSort.showResult();
	}
}
