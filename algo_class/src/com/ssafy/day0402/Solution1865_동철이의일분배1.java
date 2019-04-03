package com.ssafy.day0402;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1865_동철이의일분배1 {
	
	static int N;
	static double[][] map;
	static double[] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T  = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			memo = new double[1<<N];
			Arrays.fill(memo, -1);
			map = new double[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j] = sc.nextDouble()/100.0;
				}
			}
			double res = dfs(0,0,1.0);
			System.out.printf("#%d %.6f\n",t,res*100);
			
		}
		sc.close();
	}
	private static double dfs(int index, int status, double prob) {
		double max = 0;
		if(index==N) {
			return 1.0;
		}
		if(memo[status]>0)return memo[status];
		
		for(int i=0;i<N;++i) {
			if(((status&(1<<i))!=0))continue;
			double temp = dfs(index+1,status|(1<<i),prob)*map[index][i];
			max = max<temp?temp:max;
		}
		memo[status] = max;
		return max;
	}
}
