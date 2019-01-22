package com.ssafy.array;

import java.util.Scanner;

public class Solution21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; ++t) {
			int N = sc.nextInt();
			int SA_NUM = sc.nextInt();
			int result = 0;
			int[][] map = new int[N][N];
			int[] DIR = new int[SA_NUM];
			int X = 0;
			int Y = 0;
			for (int k = 1; k <= SA_NUM; ++k) {
				X = sc.nextInt();
				Y = sc.nextInt();
				DIR[k - 1] = sc.nextInt();
				if (map[X][Y] == 0) {
					map[X][Y] = k;
				} else {
					result = k;
				}
			}
			
			if (result == 0) {
OUTER: 			for (int k = 1; k <= SA_NUM; ++k) {
					for (int i = 0; i < N; ++i) {
						for (int j = 0; j < N; ++j) {
							if (map[i][j] == k) {
								int dir = DIR[k - 1];
								int x = i;
								int y = j;
								if (dir == 1){
									for (int jmp = 3; jmp >= 1; --jmp) {
										if (x + jmp >= N - 1) {
											map[x][y]=-1;
											continue OUTER;
										} else if (map[x + jmp][y] != 0) {
											result = k;
											break OUTER;
										} else {
											map[x][y]=-1;
											map[x + jmp][y] = k;
											x = x + jmp;
										}

									}

								}else if (dir == 2) {
									for (int jmp = 3; jmp >= 1; --jmp) {
										if (y + jmp >= N - 1) {
											map[x][y]=-1;
											break;
										} else if (map[x][y + jmp] != 0) {
											result = k;
											break;
										} else {
											map[x][y]=-1;
											map[x][y + jmp] = 1;
											y = y + jmp;
										}
									}
								} 
							} 
						} 
					}
				} 
			}

			System.out.println("#" + t + " " + result);
		}
	
	
	}
}
