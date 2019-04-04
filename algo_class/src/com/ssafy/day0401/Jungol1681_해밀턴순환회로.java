package com.ssafy.day0401;

import java.util.Scanner;

public class Jungol1681_해밀턴순환회로 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int result;
	static final int INF = Integer.MAX_VALUE/100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0)map[i][j]=INF;
			}
		}
		result = Integer.MAX_VALUE;
		visited[0]=true;
		int res = dfs(0,0,0,Integer.MAX_VALUE);
//		dfs1(0,0,0);
//		System.out.println(result);
		System.out.println(res);
	}
	private static int dfs(int index, int sum,int where,int max) {
		int res = Integer.MAX_VALUE;
		if(index==N-1) {
			return sum+map[where][0];
		}
		if(sum>max) return Integer.MAX_VALUE;
		for(int i=0;i<N;++i) {
			if(map[where][i]==INF)continue;
			if(visited[i])continue;
			visited[i]=true;
			int temp = dfs(index+1,sum+map[where][i],i,max);
			visited[i]=false;
			res=res>temp?temp:res;
			max=max<res?max:res;
		}
		return res;
	}
	private static void dfs1(int index, int sum,int where) {
		if(index==N-1) {
			if(map[where][0]!=INF) {
				if(sum+map[where][0]<result)result=sum+map[where][0];
			}
			return;
		}
		if(sum>result)return;
		for(int i=0;i<N;++i) {
			if(map[where][i]==INF)continue;
			if(visited[i])continue;
			visited[i]=true;
			dfs1(index+1,sum+map[where][i],i);
			visited[i]=false;
		}
		
	}

}
