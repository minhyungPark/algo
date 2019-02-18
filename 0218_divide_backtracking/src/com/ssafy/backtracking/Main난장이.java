package com.ssafy.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Main난장이 {

	static int N;
	static int[] numbers;
	static int targetSum;
	static int[] results;
	static int[] resultss;
	static int sum;
	static StringBuilder sb;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = 9;
		targetSum = 100;
		numbers = new int[N];
		results = new int[7];
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		sum = 0;
		subset(0,0);
		Arrays.sort(resultss);
		for(int i=0;i<7;++i) {
			sb.append(resultss[i]).append("\n");
		}
		System.out.println(sb.toString().trim());
		sc.close();
	}
	private static void subset(int index,int size) {
		if(size==7 && sum==targetSum) {
			/*for(int i=0;i<7;++i) {
				sb.append(results[i]).append("\n");
			}*/
			resultss =results.clone();
			return;
		}else if(index==N||size==7) {
			return;
		}
		
		if(sum>=targetSum) {
			return;
		}
		//선택
		sum+=numbers[index];
//		check[index] = true;
		results[size] = numbers[index];
		subset(index+1,size+1);
		sum-=numbers[index];
		
		//비선택
//		check[index] = false;
		subset(index+1,size);
		
	}

}
