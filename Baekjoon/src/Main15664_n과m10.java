import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main15664_n과m10 {
	
	static int N,M;
	static int[] numbers;
	static boolean[] visited;
	static int[] indexN;
	static LinkedHashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[N];
		visited = new boolean[N];
		indexN = new int[M];
		set = new LinkedHashSet<String>();
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);
		combination(0,-1);
//		Iterator<String> it = set.iterator();
		for (String string : set) {
			System.out.println(string);
		}
	}
	private static void combination(int depth, int index) {
		if(depth==M) {
			StringBuilder sb = new StringBuilder();
			for (int i : indexN) {
				sb.append(i).append(" ");
			}
			set.add(sb.toString());
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(i<=index)continue;
			if(!visited[i]) {
				visited[i] = true;
				indexN[depth] = numbers[i];
				combination(depth+1, i);
				visited[i] = false;
			}
		}
		
	}

}
