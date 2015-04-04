package com.study.algorithm.sort;

public class SelectionSort implements SortUtil.Sort{

	public void sort(int[] data) {
		int temp;
		for(int i=0; i<data.length; i++){
			int minIndex = i;
			for(int j=data.length-1; j>i; j--){
				if(data[j] < data[minIndex]){
					minIndex = j;
				}
			}
			SortUtil.swap(data, i, minIndex);
		}
		
	}

}
