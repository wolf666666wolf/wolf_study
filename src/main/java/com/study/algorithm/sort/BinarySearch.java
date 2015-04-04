package com.study.algorithm.sort;

import java.util.Arrays;

/**
 * 二分查找法：将已经排序（假如是升序）的数组分成两半，
 * 然后将给定值与数组分成两半的中间值进行比较，
 * 如果给定值大于中间值则在右边查找，
 * 同样按照前面的方式将右边的数组分成两半开始查找，直到找到为止。 
 * @author BULL
 *
 */
public class BinarySearch {

//	public static int find(int[] a, int key){
//		int end = a.length;
//		int index =0;
//		int start =0;
//		while(true){
//			index = start + (end-start)/2;
//			if(a[index] < key){
//				start = index;
//			}else if(a[index]>key){
//				end = index;
//			}else{
//				return index;
//			}
//			
//			System.out.println("#################start:" + start +"---- end:"+end);
//		}
//	}
	public static int find(int[] a, int fromIndex, int toIndex, int key){
		int low = fromIndex;
		int heigh = toIndex -1;
		
		while(low<=heigh){
			int mid = (low+heigh)>>>1;
			int midValue = a[mid];
			if(midValue < key){
				low = mid+1;
			}else if(midValue > key){
				heigh = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a = {1, 3, 5, 10, 11, 15, 19, 20};
		int key = 110;
		int i = find(a, 0, a.length, key);
		System.out.println("二分查找：" + i);
	
	}
}
