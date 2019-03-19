package com.ssafy.day0318;

import java.util.Scanner;

public class Main_jungol_2097_지하철 {

	static int N,M;
	static int[][] map;
	static int[][] adj;
	static boolean[] visited;
	static String result;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		adj = new int[N][N];
		visited = new boolean[N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0)adj[i][j]=9999999;
				else adj[i][j] = map[i][j];
			}
		}
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				if(i==k)continue;
				for(int j=0;j<N;++j) {
					if(i==j||j==k)continue;
					if(adj[i][j]>adj[i][k]+adj[k][j]) {
						adj[i][j] = adj[i][k]+adj[k][j];
					}
				}
			}
		}
		visited[0] = true;
		dfs(0,0,adj[0][M-1],"1");	
		System.out.println(adj[0][M-1]);
		System.out.println(result);

	}
	private static void dfs(int index,int pre, int target, String st) {
		if(target==0&&pre==M-1) {
			result = st;
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(pre!=i&&!visited[i]) {
				if(target-map[pre][i]>=0) {
					visited[i] = true;
					dfs(index+1,i,target-map[pre][i],st+" "+(i+1));
					visited[i] = false;
				}
				
			}
		}
		
	}

}
