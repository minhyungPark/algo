package com.ssafy.recursive;

import java.util.Scanner;

public class DigitSumTest {

	// 정수 N을 입력받고 각 자리수의 합을 출력
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(digitSum(N));
	}
	
	/*private static int digitSum(int n) {
		if(n/10==0) return n;
		
		return n%10 + digitSum(n/10);
	}*/
	
	private static int digitSum(int n) {
		if(n<10) return n;

		int current = n%10;
		int k = n/10;
		return current + digitSum(k);
		
	}

}
