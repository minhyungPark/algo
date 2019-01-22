package com.ssafy.recursive;

import java.util.Scanner;

public class FibonacciTest {

	public static void main(String[] args) {
		// 1,1,2,3,5,8,13
		// 전전항 + 전항 = 현재항
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			System.out.println(fibonacci(N));
		}
	}
	public static int fibonacci(int n) {
		if(n<=2) return 1;
		return fibonacci(n-2)+fibonacci(n-1);
	}

}
