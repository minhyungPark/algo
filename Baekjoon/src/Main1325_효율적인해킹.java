import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1325_효율적인해킹 {

	static int N, M;
	static boolean[] checked;
	static ArrayList<Integer>[] list;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; ++i) {
			list[i] = new ArrayList<Integer>();
		}
		int[] index = new int[N + 1];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[b].add(a);
			index[b]++;
		}
		result = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			if (index[i] != 0) {
				checked = new boolean[N + 1];
				dfs(i,i);
			}
		}
		int max = Integer.MIN_VALUE;
		int key = 0;
		for (int i = 1; i <= N; ++i) {
			if (max < result[i]) {
				max = result[i];
				key = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = key; i <= N; ++i) {
			if (max == result[i]) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString().trim());
	}

	private static void dfs(int n,int index) {

		checked[n] = true;
		for (int i = 0; i < list[n].size(); ++i) {
			if (!checked[list[n].get(i)]) {
				result[index]++;
				dfs(list[n].get(i),index);
			}

		}
	}

}
