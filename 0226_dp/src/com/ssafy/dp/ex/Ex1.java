package com.ssafy.dp.ex;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] D = new int[N+1][2];
		D[1][0] = D[1][1] = 1;
		for(int i=2;i<=N;++i) {
			D[i][0] = D[i-1][0]+D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		System.out.println(D[N][0]+D[N][1]);

	}

}
