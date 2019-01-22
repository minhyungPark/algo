package com.ssafy.hw;

import java.util.Arrays;

public class BinarySearchTest {

	static int values[] = {3,11,15,20,21,29,45,59,65,72};
	
	public static void main(String[] args) {
		System.out.println(binarySearch(65));
		System.out.println(binarySearch(3));
		System.out.println(binarySearch(72));
		System.out.println(binarySearch(2));
		System.out.println(binarySearch(50));
		System.out.println("==========================================");
		System.out.println(binarySearch2(65));
		System.out.println(binarySearch2(3));
		System.out.println(binarySearch2(72));
		System.out.println(binarySearch2(2));
		System.out.println(binarySearch2(50));
		System.out.println("==========================================");
		// Arrays.binarySearch 의 경우 못 찾았을 때, 그 key값의 예상되는 위치의 index값을 음수값으로 리턴 해준다.
		System.out.println(Arrays.binarySearch(values, 65));
		System.out.println(Arrays.binarySearch(values,3));
		System.out.println(Arrays.binarySearch(values,72));
		System.out.println(Arrays.binarySearch(values,2));
		System.out.println(Arrays.binarySearch(values,50));
	}
	private static int binarySearch(int target) {
		int start = 0;
		int end = values.length-1;
		
		while(start<=end) {
			int middle = (start + end)/2;
			if(values[middle]==target)return middle;
			else if(values[middle]<target)start = middle + 1;
			else end = middle - 1;
		}
		return -1;
	}
	private static int binarySearch2(int target) {
		return binarySearch2(target,0,values.length-1);
	}
	private static int binarySearch2(int target,int start,int end) {
		if(start>end) return -1;
		int middle = (start+end)/2;
		if(values[middle]==target)return middle;
		else if(values[middle]>target)return binarySearch2(target, start, middle-1);
		else return binarySearch2(target, middle+1, end);
	}
}
