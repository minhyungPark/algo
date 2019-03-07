package com.ssafy.practice;

import java.util.Scanner;

public class Soulution32 {

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int[][] map;
	static int N,M;
	static int pN;
	static int[][] person;
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N=sc.nextInt();
			M=sc.nextInt();
			pN = sc.nextInt();
			map = new int[N][M];
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					map[i][j]=sc.nextInt();
				}
			}
			person = new int[pN][3];
			for(int i=0;i<pN;++i) {
				person[i][0] = sc.nextInt();
				person[i][1] = sc.nextInt();
				person[i][2] = sc.nextInt();
			}
			
			
			
		}
	}

}
