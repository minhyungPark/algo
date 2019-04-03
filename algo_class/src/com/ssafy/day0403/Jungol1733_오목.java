package com.ssafy.day0403;

import java.util.Scanner;

public class Jungol1733_오목 {
	
	static int N = 19;
	static int[][] map;
	static int[] dx = {1,1,1,0,-1,-1,-1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		int result = 0;
		int x = 0;
		int y = 0;
OUTER:	for(int k=1;k<=2;++k) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<N;++i) {
					if(map[i][j]==k) {
						boolean flag = go(i,j,k);
						if(flag) {
							result=k;x=i+1;y=j+1;
							break OUTER;
						}
					}
				}
			}
		}
		System.out.println(result);
		if(result!=0) System.out.println(x+" "+y);
	}
	private static boolean go(int xx, int yy, int k) {
		for(int d=0;d<4;++d) {
			int nx = xx;
			int ny = yy;
			int cnt = 0;
			int rD = (d+4)%8;
			while(map[nx][ny]==k) {
				cnt++;
				if(cnt>5) return false;
				nx+=dx[d];
				ny+=dy[d];
				if(nx<0||ny<0||nx>=N|ny>=N)break;
			}
			nx = xx;
			ny = yy;
			cnt-=1;
			while(map[nx][ny]==k) {
				cnt++;
				if(cnt>5) return false;
				nx+=dx[rD];
				ny+=dy[rD];
				if(nx<0||ny<0||nx>=N|ny>=N)break;
			}
			if(cnt==5)return true;
		}
		return false;
	}
}