package com.study.algorithm.sort;

public class QuickSort implements SortUtil.Sort{

	public void sort(int[] data) {
	
		
	}

//	private int partition(int[] data, int low, int heigh){
//	  int key = data[low];
//	  while(low<heigh){
//	    while(low<heigh && data[low]<key){
//	      low++;
//	    }
//	    
//	    
//	  }
//	}
	private void quickSort(int[] data, int i, int j){
		int low=i;
		int heigh=j;
	    int pivotIndex = (i+j)/2;
	    int tmp = data[pivotIndex];
	    
		while(low<=heigh){
		  while((heigh>pivotIndex)&& data[heigh]>tmp){
		    heigh--;
		  }
		  
		  while((low<pivotIndex) && data[low]<data[pivotIndex]){
		    low++;
		  }
		  if(low<heigh){
		    swap(data, low, heigh);
		  }
		  
		}
	}
	private void swap(int[] data, int i, int j){
	  int temp = data[i];
	  data[i]=data[j];
	  data[j]=temp;
	}
}
