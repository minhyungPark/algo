package com.ssafy.array;

import java.util.Scanner;

public class Solution42 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; ++t) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int JUMP_NUM = sc.nextInt();

			int[][] map = new int[N + 1][N + 1];

			map[X][Y] = 1; // �����

			for (int j = 0; j < JUMP_NUM; ++j) {
				int X_J = sc.nextInt();
				int Y_J = sc.nextInt();
				map[X_J][Y_J] = 2; //
			}

			int CONTROL = sc.nextInt();
			int[] DIR = new int[CONTROL];
			int[] COUNT = new int[CONTROL];

			for (int c = 0; c < CONTROL; ++c) {
				DIR[c] = sc.nextInt();
				COUNT[c] = sc.nextInt();
			}
			// �Է� ��

OUTER:		for (int c = 0; c < CONTROL; ++c) {

				if (DIR[c] == 1) {
					for(int cnt=1;cnt<=COUNT[c];++cnt) {
						if (X - 1 <= 0 || map[X - 1][Y] == 2) {
							X = 0;
							Y = 0;
							break OUTER;
						} else {
							X = X - 1;
						}
						
					}

				} else if (DIR[c] == 2) {
					for(int cnt=1;cnt<=COUNT[c];++cnt) {
						if (Y + 1 > N || map[X][Y + 1] == 2) {
							X = 0;
							Y = 0;
							break OUTER;
						} else {
							Y = Y + 1;
						}
						
					}

				} else if (DIR[c] == 3) {
					for(int cnt=1;cnt<=COUNT[c];++cnt) {
						if (X + 1 > N || map[X + 1][Y] == 2) {
							X = 0;
							Y = 0;
							break OUTER;
						} else {
							X = X + 1;
						}
						
					}
						

				} else if (DIR[c] == 4) {
					for(int cnt=1;cnt<=COUNT[c];++cnt) {
						if (Y - 1 <= 0 || map[X][Y - 1] == 2) {
							X = 0;
							Y = 0;
							break OUTER;
						} else {
							Y = Y - 1;
						}
					}
				}

			}

			System.out.println("#" + (t + 1) + " " + X + " " + Y);

		} // ���� for
	}

}
