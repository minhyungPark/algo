package com.ssafy.day0402;
import java.util.Scanner;

public class Solution1865_동철이의일분배 {

	static int N;
	static double[][] map;
	static double result;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			result = Double.MIN_VALUE;
			map = new double[N][N];
			visited = new boolean[N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					int temp = sc.nextInt();
					map[i][j] = temp/100.0;
				}
			}
			dfs(0,1.0);
			System.out.printf("#"+t+" "+"%.6f\n",result*100);
		}
	}
	private static void dfs(int index, double prob) {
		if(index==N) {
			if(prob>result)result = prob;
			return;
		}
		if(prob<=result)return;
		for(int i=0;i<N;++i) {
			if(visited[i])continue;
			if(map[index][i]==0)continue;
			visited[i]=true;
			dfs(index+1,prob*map[index][i]);
			visited[i]=false;
		}
		
	}

}
