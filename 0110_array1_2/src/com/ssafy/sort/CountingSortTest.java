package com.ssafy.sort;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] number = new int[N];
		int[] result = new int[N];
		int[] count = new int[10];
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		// step1 카운트 세기
		for(int i=0;i<N;++i) {
			number[i] = sc.nextInt();
			count[number[i]]++;
			
			if(number[i]<min)min=number[i];
			if(number[i]>max)max=number[i];
		}
		// step2 카운트 누적하기
		for(int i=min+1;i<=max;++i) {
			count[i]=count[i-1]+count[i];
		}
		// step3 누적된 카운트 이용하여 각 원소 자리찾아 넣기
		for(int i=N-1;i>0;--i) {
			result[count[number[i]]-1] = number[i];
			count[number[i]]--;
		}
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(result));
		
	}

}
