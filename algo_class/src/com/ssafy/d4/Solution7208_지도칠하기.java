package com.ssafy.d4;

import java.util.Scanner;

public class Solution7208_지도칠하기 {

	static int N;
	static int[][] adj;
	static int[] color;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			result = Integer.MAX_VALUE;
			N = sc.nextInt();
			adj = new int[N][N];
			color = new int[N];
			for(int i=0;i<N;++i) {
				color[i] = sc.nextInt();
			}
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					adj[i][j]=sc.nextInt();
				}
			}
			int[] number = new int[N];
			dfs(0,number);
			System.out.println("#"+t+" "+result);
			
		}
		sc.close();

	}
	private static void dfs(int index,int[] numb) {
		if(index == N) {
			boolean flag = true;
outer:		for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(adj[i][j]==0)continue;
					if(numb[i]==numb[j]) {
						flag = false;
						break outer;
					}
				}
			}
			if(flag) {
				int cnt=0;
				for(int i=0;i<N;++i) {
					if(numb[i]!=color[i])cnt++;
				}
				result = result>cnt?cnt:result;
			}
			return;
		}
		
		for(int i=1;i<=4;++i) {
			numb[index] = i;
			dfs(index+1,numb);
			
		}
	}

}
