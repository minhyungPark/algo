package com.ssafy.day0404;

import java.util.Scanner;

public class Solution3234_준환이의양팔저울2 {
	
	static int N,result;
	static int[] num;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			num = new int[N];
			int max = 0;
			for(int i=0;i<N;++i) {
				num[i]=sc.nextInt();
				max+=num[i];
			}
			int[][][] dp = new int[max+1][1<<N][N+1];
			for(int i=0;i<N;++i) {
				dp[num[i]][1<<i][1] = 1;
			}
			for(int i=1;i<=N;++i) {
				for(int d=0;d<N;++d) {
					for(int j=0;j<max+1;++j) {
						for(int k=0;k<1<<N;++k) {
							if((k&(1<<d))==0&&dp[j][k][i-1]!=0) {
								dp[j+num[d]][k|(1<<d)][i]+=dp[j][k][i-1];
								if(j>=num[d])dp[j-num[d]][k|(1<<d)][i]+=dp[j][k][i-1];
							}
						}
					}
				}
			}
			int res = 0;
			for(int i=0;i<max+1;++i) {
				res+=dp[i][(1<<N)-1][N];
			}
			System.out.println("#"+t+" "+res);
			
		}
		sc.close();
	}
}
