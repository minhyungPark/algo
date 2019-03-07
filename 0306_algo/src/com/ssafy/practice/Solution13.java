package com.ssafy.practice;

import java.util.Scanner;

public class Solution13 {

	static int[] dx = {0,0,1,-1,1,-1,1,-1};
	static int[] dy = {1,-1,0,0,1,1,-1,-1};
	static int[][] map;
	static int[][] build;
	static int N;
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			map = new int[N][N];
			build = new int[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(sc.next().charAt(0)=='B')map[i][j]=1;
				}
			}
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==1) {
						go(i,j);
					}
				}
			}
			int result = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(build[i][j]>result) {
						result = build[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+result);
			
		}
	}
	private static void go(int x, int y) {
		for(int i=0;i<8;++i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=N||ny>=N)continue;
			if(map[nx][ny]==0) {
				build[x][y]=2;
				return;
			}
		}
		int cnt=0;
		for(int i=0;i<N;++i) {
			if(map[i][y]==1)cnt++;
		}
		for(int j=0;j<N;++j) {
			if(map[x][j]==1)cnt++;
		}
		build[x][y] = cnt-1;
	}

}
