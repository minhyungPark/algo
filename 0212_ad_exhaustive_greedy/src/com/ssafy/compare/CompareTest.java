package com.ssafy.compare;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

	public static void main(String[] args) {
		int[] arr = {3,5,2,5,10};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("=============================");
		Integer[] arr2 = {3,5,2,5,10};
		System.out.println(Arrays.toString(arr2));
		Arrays.sort(arr2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1-o2);
			}
		});
		System.out.println(Arrays.toString(arr2));

		System.out.println("===========================");
		String arr3[] = {"hello","hi","bye"};
		System.out.println(Arrays.toString(arr3));
		Arrays.sort(arr3,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -1*o1.compareTo(o2);
			}
		});
		System.out.println(Arrays.toString(arr3));
	}
}
