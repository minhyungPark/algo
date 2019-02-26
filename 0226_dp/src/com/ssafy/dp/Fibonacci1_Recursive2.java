package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci1_Recursive2 {

	static int call[];
	static long fi[];
	static long fibo(int n) {
		call[n]++;
		if(n<=1)return n;
		if(fi[n]==0)
			fi[n] = fibo(n-2)+fibo(n-1);
		return fi[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		call = new int[N+1];
		fi = new long[N+1];
		System.out.println(fibo(N));
		System.out.println(Arrays.toString(call));
	}
}
