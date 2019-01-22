package com.ssafy.recursive;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciTest2 {

	static int[] fibo;

	public static int fibonacci(int n) {
		// 	1. 메모리에 계산된 값이 있는지 확인
		//	2-a. 있으면 계산하지 않고 그 값 바로 리턴
		//	2-b. 없으면 계산 로직 수행후 결과 메모리에 넣고 리턴
		
		if(fibo[n]!=-1) return fibo[n];
		return fibo[n]=fibonacci(n-2)+fibonacci(n-1);
	}
	
	public static void main(String[] args) {
		// 1,1,2,3,5,8,13
		// 전전항 + 전항 = 현재항
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int n = sc.nextInt();
			fibo = new int[n+1];
			Arrays.fill(fibo, -1);
			fibo[0] = 0;
			fibo[1] = 1;
			System.out.println(fibonacci(n));
		}
	}

}
