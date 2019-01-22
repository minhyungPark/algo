package com.ssafy.array;

import java.util.Arrays;

public class BubbleSortTest {

	public static void main(String[] args) {
		int[] arr = {69,10,5,2,7,13};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void bubbleSort(int[] arr) {
		int size = arr.length;
		int temp=0;
		for(int i=size-1;i>0;--i) {
			for(int j=0;j<i;++j) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	private static void bubbleSort2(int[] arr) {
		int size = arr.length;
		boolean isSwap = false;
		int temp=0;
		for(int i=size-1;i>0;--i) {
			isSwap = false;
			for(int j=0;j<i;++j) {
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSwap = true;
				}
			}
			if(!isSwap)break;
		}
	}

}
