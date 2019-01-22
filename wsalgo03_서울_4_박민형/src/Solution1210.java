import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1210 {

	static int N;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input1210.txt"));
		Scanner sc = new Scanner(System.in);
		N = 100;
		int[][] map = new int[N][N];

		int T = 10;

		for (int t = 1; t <= T; ++t) {
			int ans = sc.nextInt();
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					map[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			int xPos = N - 2;
			int yPos = 0;
			for (int j = 0; j < N; ++j) {
				if (map[N - 1][j] == 2) {
					yPos = j;
				}
			}
			while (xPos > 0) {
				if (yPos - 1 > 0 && map[xPos][yPos - 1] == 1) {
					while (yPos > 0 && map[xPos][yPos] == 1) {
						--yPos;
					}
					++yPos;
					--xPos;
				} else if (yPos + 1 < N && map[xPos][yPos + 1] == 1) {
					while (yPos < N - 1 && map[xPos][yPos] == 1) {
						++yPos;
					}
					--yPos;
					--xPos;
				} else {
					--xPos;
				}
			}
			result = yPos;

			System.out.println("#" + t + " " + result);
		}
	}
}
