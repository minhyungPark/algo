package com.ssafy;

import java.util.Scanner;

public class 장난감조립 {

	static int N;
	static int M;
	static int[][] toyInfo;
	static int[][] answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		toyInfo = new int[M][3];
		answer = new int[N][2];
		for(int i=0;i<M;i++) {
			for(int j=0;j<3;j++) {
				toyInfo[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for(int i=0;i<N;i++) {
			answer[i][0] = i+1;
		}
		
		check(N,1);	// 부품번호, 수량
		
		for(int i=0;i<N;i++) {
			if(answer[i][1] != 0) {	// 기본 부품만.
				System.out.println(answer[i][0]+" "+answer[i][1]);
			}
		}
	}

	private static void check(int no, int count) {
		boolean isBasic = true;
		
		for(int i=0;i<M;++i) {
			if(no==toyInfo[i][0]) {
				isBasic = false;
				check(toyInfo[i][1],count*toyInfo[i][2]);
			}
		}
		if(isBasic) {
			answer[no-1][1] += count;
		}
		
	}
}
