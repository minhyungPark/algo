package 삼성코테;

import java.util.*;

public class ad2 {

	private static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[] result;

	private static void print() {
		System.out.println();
		for (int i = 8; i >= 0; i--) { // 기본값은 적당히 8로잡음
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != 0)
					System.out.format("%2d", map[i][j]); 
				else {
					System.out.format("  ");
				}
			}
			System.out.println();
		}
		System.out.println("---------------");
		System.out.format("%2d%2d%2d%2d%2d%2d <- index \n", 0, 1, 2, 3, 4, 5);
		System.out.println("===========================");
	}

	private static void downStone() {

		for (int i = 1; i < 100; i++) {
			for (int j = 0; j < 6; j++) {

				if (map[i - 1][j] == 0 && map[i][j] != 0) {
					map[i - 1][j] = map[i][j];
					map[i][j] = 0;
				}
			}
		}
	}

	private static void allStone(int index) {

		ArrayList<Node> list = new ArrayList<Node>();

		int downStoneCounter = 0;
		for (int i = 0; i < 100; i++) {

			int[] count = new int[3];
			// print();
			for (int j = 0; j < 5; j++) { // 가로일떄 체크
				if (map[i][j] == map[i][j + 1]) {
					count[map[i][j]]++;

				}

			}

			if (count[1] >= 3) {
				if (index == 1)
					result[1] += count[1] + 1;
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == 1) {
						list.add(new Node(i, j));
					}
				}
				downStoneCounter++;

			} else if (count[2] >= 3) {

				if (index == 2)
					result[2] += count[2] + 1;
				for (int j = 0; j < 6; j++) {
					if (map[i][j] == 2) {
						list.add(new Node(i, j));
					}
				}
				downStoneCounter++;
			}

		}

		for (Node temp : list) {
			map[temp.x][temp.y] = 0;

		}
		for (int i = 0; i <= downStoneCounter; i++) {
			downStone();
		}

	}

	private static boolean newStone(int col, int people) {

		boolean newCheck = false;
		int row;
		for (row = 0; row < 100; row++) {
			if (map[row][col] == 0) {
				map[row][col] = people;
				break;
			}
		}
		// 인풋
		int count = 0;
		int max = 0;
		for (int i = 0; i < 6; i++) { // 가로로 4개이상
			if (map[row][i] == people) {
				count++;
			} else if (map[row][i] != people) {
				count = 0;
			}
			max = Math.max(max, count);

		}

		if (max >= 4) {
			newCheck = true;
			for (int i = 0; i < 6; i++) {
				if (map[row][i] == people) {
					map[row][i] = 0;
				}
			}
			result[people] += max;
			downStone();
		}

		return newCheck;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int tnum = input.nextInt();

		for (int t = 1; t <= tnum; t++) {

			map = new int[100][6];
			result = new int[3];

			int N = input.nextInt();

			for (int i = 0; i < N; i++) {

				int col = input.nextInt();

				print();
				if (newStone(col, (i % 2) + 1)) {
					allStone((i % 2) + 1);
				}

			}

			System.out.println("최종모습");
			print();
			System.out.println("#" + t + " " + Math.abs(result[1] - result[2]));

		}

	}

}
