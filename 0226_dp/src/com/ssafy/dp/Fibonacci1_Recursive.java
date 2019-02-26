package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci1_Recursive {

	static int call[];
	static long fibo(int n) {
		call[n]++;
		if(n<=1)return n;
		return fibo(n-2)+fibo(n-1);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		call = new int[N+1];
		System.out.println(fibo(N));
		System.out.println(Arrays.toString(call));
	}

}
