package com.ssafy.dp.ex;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] result = new int[N+1];
		result[1] = 2;
		result[2] = 5;
		for(int i=3;i<=N;++i) {
			result[i] = 2*result[i-1]+result[i-2];
		}
		System.out.println(result[N]);
	}
}
