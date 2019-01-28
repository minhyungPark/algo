package com.ssafy.sort;

import java.util.Arrays;

public class InsertionSortTest {

	public static void insertionSort(int list[]) {
		final int SIZE = list.length;
		for(int i=1;i<SIZE;++i) {
			int temp = list[i];
			for(int j=0;j<i;++j) {
				if(temp<list[j]) {
					for(int k=i-1;k>=j;--k) {
						list[k+1] = list[k];
					}
					list[j] = temp;
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] list = {45,11,54,2,3,6,9,5,10,54};
		insertionSort(list);
		System.out.println(Arrays.toString(list));
	}

}
