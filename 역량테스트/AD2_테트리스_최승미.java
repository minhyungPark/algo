import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AD_block {

	static int N;
	static int Ascore, Bscore;
	static int[][] map;
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[100][6];
			Ascore = 0;
			Bscore = 0;
			for (int n = 0; n < N; n++) {
				int inputY = sc.nextInt();
				int floorX = 0;
				for (int x = 0; x < 100; x++) {
					if (map[x][inputY] == 0) {
						map[x][inputY] = n % 2 + 1;
						floorX = x;
						break;
					}
				}
				int AB = map[floorX][inputY];
				searchBlock(floorX, inputY, map[floorX][inputY]);
				afterFall(floorX, AB);
			}
			System.out.println("#" + t + " " + Math.abs(Ascore - Bscore));

		}
		sc.close();
	}

	private static void afterFall(int floorX, int AB) {
		boolean check=false;
		for (int x = floorX; x < 100; x++) {
			int zero = 0;
			for (int y = 0; y < 6; y++) {
				int Acount = 1;
				int Bcount = 1;
				if (map[x][y] == 0) {
					zero++;
				}
				if (map[x][y] == 1) {
					Queue<Integer> q = new LinkedList<>();
					q.offer(y);
					while (!q.isEmpty()) {
						int curY = q.poll();
						int nextY = curY + 1;
						if (nextY < 6 && map[x][nextY] == 1) {
							q.offer(nextY);
							Acount++;
						}
					}
					if (Acount >= 4) {
						check=true;
						stack.push(new int[] { x, y, y + Acount - 1 });
						if (AB == 1) {
							Ascore += Acount;
						}
						break;
					}
				}
				if (map[x][y] == 2) {
					Queue<Integer> q = new LinkedList<>();
					q.offer(y);
					while (!q.isEmpty()) {
						int curY = q.poll();
						int nextY = curY + 1;
						if (nextY < 6 && map[x][nextY] == 2) {
							q.offer(nextY);
							Bcount++;
						}
					}
					if (Bcount >= 4) {
						check=true;
						stack.push(new int[] { x, y, y + Bcount - 1 });
						if (AB == 2) {
							Bscore += Bcount;
						}
						break;
					}
				}
			}
			if (zero >= 3) {
				break;
			}
		}
		if(!check) return;
		while (!stack.isEmpty()) {
			int[] pop = stack.pop();
			fallBlock(pop[0], pop[1], pop[2]);
		}
		afterFall(floorX, AB);
	}

	private static void searchBlock(int floorX, int inputY, int AB) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(inputY);
		int leftY = -1;
		int rightY = 6;
		int count = 1;
		while (!q.isEmpty()) {
			int curY = q.poll();
			int nextY = curY - 1;
			if (nextY >= 0 && map[floorX][nextY] == map[floorX][curY]) {
				q.offer(nextY);
				count++;
				leftY = nextY;
			}
		}
		q.offer(inputY);
		while (!q.isEmpty()) {
			int curY = q.poll();
			int nextY = curY + 1;
			if (nextY < 6 && map[floorX][nextY] == map[floorX][curY]) {
				q.offer(nextY);
				count++;
				rightY = nextY;
			}
		}
		if(leftY<0) leftY++;
		if(rightY>=6) rightY--;
		if (count >= 4) {
			if (AB == 1) {
				Ascore += count;
			}
			if (AB == 2) {
				Bscore += count;
			}
			fallBlock(floorX, leftY, rightY);
		}
	}

	private static void fallBlock(int floorX, int leftY, int rightY) {
		for (int y = leftY; y <= rightY; y++) {
			for (int x = floorX; x < 99; x++) {
				map[x][y] = map[x + 1][y];
				if (x + 1 == 99) {
					map[x + 1][y] = 0;
				}
				if (map[x][y] == 0) {
					break;
				}
			}
		}

	}

}
