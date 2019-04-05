package com.ssafy.day0404;

import java.util.Scanner;

public class Solution3234_준환이의양팔저울3 {
	
	static int N,result;
	static int[] num;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			num = new int[N];
			for(int i=0;i<N;++i) {
				num[i]=sc.nextInt();
			}
			dp = new int[9990][1<<N];
			int res = dfs(0,0,0);
			System.out.println("#"+t+" "+res);
		}
		sc.close();
	}
	private static int dfs(int depth, int weight, int status) {
		int res = dp[weight][status];
		if(depth==N)return 1;
		if(res>0)return res;
		for(int i=0;i<N;++i) {
			if((status&(1<<i))==0) {
				int temp1 = dfs(depth+1,weight+num[i],status|(1<<i));
				res+=temp1;
				if(weight>=num[i]) {
					int temp2 = dfs(depth+1,weight-num[i],status|(1<<i));
					res+=temp2;
				}
			}
		}
		dp[weight][status] = res;
		
		return res;
	}
}
