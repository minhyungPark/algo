package com.ssafy.divide;

import java.util.Arrays;

public class QuickSortTest {

	
	public static void quickSort(int[] list,int begin,int end) {
		
		if(begin<end) {
			//1. 피봇 위치 확정
			int pivot=fixPivot(list,begin,end);
			//2. 피봇왼쪽집합 정렬
			quickSort(list,begin,pivot-1);
			//3. 피봇 오른쪽 집합 정렬
			quickSort(list,pivot+1,end);
		}
	}
	private static int fixPivot(int[] list, int begin, int end) {
		
		int pivot = begin, left = begin +1, right = end,temp;
		do {
			// left포인터는 왼쪽에 있으면 안되는 값(피봇보다 같거나 큰값) ==> 오른쪽으로 보내야하는 값을 찾아 오른쪽으로 이동
			while(left<end&&list[left]<list[pivot])left++;
			// right 포인토는 오른쪽에 있으면 안되는 값(피봇보다 작은값) ==> 왼쪽으로 보내야하는 값을 찾아 왼쪽으로 이동
			while(right>pivot && list[right]>=list[pivot])right--;
			if(left<right) {
				temp = list[left];
				list[left] = list[right];
				list[right] = temp;
			}
		} while (left<right);
		//피봇의 위치값과 right 포인터의 위치값 교환하여 피봇위치 확정==> [작은값]피봇[같거나큰값]
		temp = list[pivot];
		list[pivot] = list[right];
		list[right] = temp;
		
		return right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] list = {69,10,30,2,16,8,31,22};
		int[] list = {5,4,3,2,1,8,31,22};
		System.out.println(Arrays.toString(list));
		quickSort(list,0,list.length-1);
		System.out.println(Arrays.toString(list));
	}

}
