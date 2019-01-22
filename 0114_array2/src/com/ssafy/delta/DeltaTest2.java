package com.ssafy.delta;

import java.util.Scanner;


/*
2
3
1 1
4
3 3


*/

public class DeltaTest2 {

	static int MAX = Integer.MAX_VALUE;
	// 상,하,좌,우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// 상,하,좌,우
	static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T_COUNT = sc.nextInt();
		int N ,X, Y;
		int[][] map;
		for(int t=0; t<T_COUNT; ++t) {
			N = sc.nextInt(); // 배열크기
			X = sc.nextInt(); // x
			Y = sc.nextInt(); // y	
			map = new int[N][N];
			map[X][Y] = 2;
			
			int newX,newY;
			for(int d=0;d<direction.length;++d) {
				newX = X + direction[d][0];
				newY = Y + direction[d][1];
				if(newX>=0 && newY>=0 && newX<N && newY<N) map[newX][newY] = 1;
			}
			
			print(map);
			System.out.println("===========================");
		}
		
	}
	
	private static void print(int[][] map) {
		
		for (int[] row : map) {
			for (int cell : row) {
				System.out.print(cell+"\t");
			}
			System.out.println();
		}
	}

}




