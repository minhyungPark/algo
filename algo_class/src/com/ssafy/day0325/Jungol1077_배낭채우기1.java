package com.ssafy.day0325;

import java.util.Scanner;

public class Jungol1077_배낭채우기1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[][] back = new int[N+1][2];
		for(int i=1;i<=N;++i) {
			back[i][0]=sc.nextInt();
			back[i][1]=sc.nextInt();
		}
		int[][] dp = new int[N+1][W+1];
		for(int i=1;i<=N;++i) {
			for(int j=0;j<=W;++j) {
				if(back[i][0]<=j) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-back[i][0]]+back[i][1]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][W]);
		
		
	}

}
