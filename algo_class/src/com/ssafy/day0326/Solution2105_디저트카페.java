package com.ssafy.day0326;

import java.util.Scanner;

public class Solution2105_디저트카페 {

	static int N;
	static int[][] map;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {-1,1,1,-1};
	static boolean[] eat;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			map = new int[N][N];
			result = -1;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j){
					map[i][j]=sc.nextInt();				
				}
			}
			eat = new boolean[101];
			for(int i=0;i<N-2;++i) {
				for(int j=1;j<N-1;++j) {
					int[] temp = {i,j};
					dfs(temp,i,j,0,0);
				}
			}
			System.out.println("#"+t+" "+result);
		}
		sc.close();

	}
	private static void dfs(int[] start,int x,int y,int d,int k) {
		
		if(start[0]==x&&start[1]==y&&d==3) {
			if(k>result)result = k;
			return;
		}
		
		int nx = x+dx[d];
		int ny = y+dy[d];
		if(nx>=0&&ny>=0&&nx<N&&ny<N) {
			if(!eat[map[nx][ny]]) {
				eat[map[nx][ny]]=true;
				dfs(start,nx,ny,d,k+1);
				eat[map[nx][ny]]=false;
			}
		}
		if(d!=3) {
			int nd = d+1;
			nx = x+dx[nd];
			ny = y+dy[nd];
			if(nx>=0&&ny>=0&&nx<N&&ny<N) {
				if(!eat[map[nx][ny]]) {
					eat[map[nx][ny]]=true;
					dfs(start,nx,ny,nd,k+1);
					eat[map[nx][ny]]=false;
				}
			}
		}
		
	}

}
