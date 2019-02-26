package com.ssafy.dp;

import java.util.Scanner;

public class BinomialCoef {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] coef = new int[N+1][K+1];
		/*for(int i=0;i<=N;++i) {
			coef[i][0] = coef[i][i] = 1;
		}*/
		
		for(int i=0;i<=N;++i) {
			int end = i<K ? i:K;
			for(int j=0;j<=end;++j) {
				if(i==j||j==0)coef[i][j]=1;
				else coef[i][j] = coef[i-1][j-1]+coef[i-1][j];
			}
		}
		/*for(int i=0;i<=N;++i) {
			for(int k=0;k<=i;++k) {
				if(i==k||k==0)coef[i][k] = 1;
				else coef[i][k] = coef[i-1][k-1]+coef[i-1][k];
			}
		}*/
		System.out.println(coef[N][K]);
	}

}
