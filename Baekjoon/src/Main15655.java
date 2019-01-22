import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15655 {

	static int[] numbers;
	static int N;
	static int M;
	static int[] per;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		per = new int[M];

		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		permutation(0, 0);
	}

	private static void permutation(int index, int flag) {
		if (index == M) {
			for (int i = 0; i < M; ++i) {
				System.out.print(per[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; ++i) {
			if ((flag & (1 << i)) == 0) {
				per[index] = numbers[i];
				flag = (flag | (1 << i));
				permutation(index + 1, flag);
			}
		}
	}

}
