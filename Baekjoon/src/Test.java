import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test{

	static int N,M;
	static StringBuilder sb;
//	static boolean[] visited;
	static int[] num;
	static int[] numbers;
	static HashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		set = new HashSet<String>();
		numbers = new int[N];
		for(int i=0;i<N;++i) {
			numbers[i] =sc.nextInt();
		}
		Arrays.sort(numbers);
//		visited = new boolean[N+1];
		num = new int[M];
		sb = new StringBuilder();
		dfs(0,0);
		System.out.println(sb.toString().trim());
	}
	private static void dfs(int index,int j) {
		if(index==M) {
			String temp = Arrays.toString(num);
			if(!set.contains(temp)) {
				for(int i=0;i<M;++i) {
					sb.append(num[i]).append(" ");
				}
				sb.append("\n");
				set.add(temp);
			}
			return;
		}
		
		for(int i=j;i<N;++i) {
			num[index] = numbers[i];
			dfs(index+1,i);
//			if(!visited[i]) {
//				visited[i] = true;
//				visited[i] = false;
//			}
		}
		
	}

}
