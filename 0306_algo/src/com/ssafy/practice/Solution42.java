package com.ssafy.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Solution42 {

	static int N;
	static int[][] map;
	static int[] pos;
	static int jN;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			map = new int[N+1][N+1];
			pos = new int[2];
			pos[0]= sc.nextInt();
			pos[1]= sc.nextInt();
			jN = sc.nextInt();
			for(int i=0;i<jN;++i) {
				map[sc.nextInt()][sc.nextInt()] = 1;
			}
			int goN = sc.nextInt();
			int[][] go = new int[goN][2];
			for(int i=0;i<goN;++i) {
				go[i][0] = sc.nextInt();
				go[i][1] = sc.nextInt();
			}
			System.out.println(Arrays.toString(pos));
			for(int i=0;i<goN;++i) {
				if(!jump(go[i][0]-1,go[i][1]))break;
			}
			System.out.println("#"+t+" "+pos[0]+" "+pos[1]);
		}

	}
	private static boolean jump(int d, int n) {

		for(int i=0;i<n;++i) {
			int nx = pos[0]+dx[d];
			int ny = pos[1]+dy[d];
			if(nx<=0||ny<=0||nx>N||ny>N) {
				pos[0]=0;
				pos[1]=0;
				System.out.println(Arrays.toString(pos));
				return false;
			}
			if(map[nx][ny]==1) {
				pos[0]=0;
				pos[1]=0;
				System.out.println(Arrays.toString(pos));
				return false;
			}
			pos[0]=nx;
			pos[1]=ny;
			System.out.println(Arrays.toString(pos));
		}
		return true;
	}

}
