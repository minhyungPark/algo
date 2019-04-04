package com.ssafy.day0404;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4013_특이한자석 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; ++t) {
			int K = sc.nextInt();
			int[][] tob = new int[4][8];
			for (int i = 0; i < 4; ++i) {
				for (int j = 0; j < 8; ++j) {
					tob[i][j] = sc.nextInt();
				}
			}
			int[][] order = new int[K][2];
			for (int i = 0; i < K; ++i) {
				order[i][0] = sc.nextInt() - 1;
				order[i][1] = sc.nextInt();
			}
			int[] num = new int[4];
			for (int i = 0; i < K; ++i) {
				Arrays.fill(num, 0);
				num[order[i][0]] = order[i][1];
				go(order[i][0], order[i][1], tob, num);
				for (int j = 0; j < 4; ++j) {
					roll(tob, j, num[j]);
				}
			}
			int res = 0;
			for (int i = 0; i < 4; ++i) {
				if (tob[i][0] == 1)
					res += Math.pow(2, i);
			}
			System.out.println("#" + t + " " + res);
		}
		sc.close();
	}

	private static void roll(int[][] tob, int who, int d) {
		int temp;
		switch (d) {
		case 1:
			temp = tob[who][7];
			for (int i = 7; i >= 1; --i) {
				tob[who][i] = tob[who][i - 1];
			}
			tob[who][0] = temp;
			break;
		case -1:
			temp = tob[who][0];
			for (int i = 0; i < 7; ++i) {
				tob[who][i] = tob[who][i + 1];
			}
			tob[who][7] = temp;
			break;
		}
	}

	private static void go(int who, int d, int[][] tob, int[] num) {
		if (who != 3) {
			if (tob[who][2] != tob[who + 1][6] && num[who + 1] == 0) {
				num[who + 1] = d * -1;
				go(who + 1, -1 * d, tob, num);
			}
		}
		if (who != 0) {
			if (tob[who][6] != tob[who - 1][2] && num[who - 1] == 0) {
				num[who - 1] = d * -1;
				go(who - 1, -1 * d, tob, num);
			}
		}
	}
}
