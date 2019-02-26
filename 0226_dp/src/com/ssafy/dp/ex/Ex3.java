package com.ssafy.dp.ex;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] result = new int[100000000];
		result[1] = 1;
		result[2] = 1;
		result[3] = 3;
		result[4] = 1;
		result[5] = 2;
		
		for(int i=6;i<=N;++i) {
			result[i] = Math.min(result[i-1], Math.min(result[i-4], result[i-6]))+1;
		}
		System.out.println(result[N]);
	}
}
