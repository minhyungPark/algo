package com.ssafy.practice;

import java.util.Scanner;

public class SaultMan {

	static int N,num;
	static int[] dx= {1,0};
	static int[] dy= {0,1};
	static boolean[][] visited;
	static int[][] map;
	static int[][] sault;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			num = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			sault = new int[num][3];
			for(int i=0;i<num;++i) {
				sault[i][0] = sc.nextInt();
				sault[i][1] = sc.nextInt();
				sault[i][2] = sc.nextInt();
			}
			int result = 0;
			for(int i=0;i<num;++i) {
				if(!jump(sault[i])) {
					result = i+1;
					break;
				}
			}
			System.out.println("#"+t+" "+result);
		}

	}
	private static boolean jump(int[] s) {
		int x = s[0];
		int y = s[1];
		int d = s[2]-1;
		if(visited[x][y])return false;
		visited[x][y] = true;
		for(int i=0;i<3;++i) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=N||ny>=N)return true;
			if(visited[nx][ny])return false;
			visited[nx][ny] = true;
			x= nx;
			y= ny;
		}
		for(int i=0;i<2;++i) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=N||ny>=N)return true;
			if(visited[nx][ny])return false;
			visited[nx][ny] = true;
			x= nx;
			y= ny;
		}
		for(int i=0;i<1;++i) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=N||ny>=N)return true;
			if(visited[nx][ny])return false;
			visited[nx][ny] = true;
			x= nx;
			y= ny;
		}
		return true;
	}

}
