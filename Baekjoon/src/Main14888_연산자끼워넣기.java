import java.util.HashSet;
import java.util.Scanner;

public class Main14888_연산자끼워넣기 {

	static int N;
	static int[] numbers;
	static int[] op;	// + - * /
	static int opN;
	static int[] opOrder;
	static boolean[] visited;
	static HashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		set = new HashSet<String>();
		op = new int[N-1];
		visited = new boolean[N-1];
		opOrder = new int[N-1];
		int index = 0;
		for(int i=0;i<4;++i) {
			int count = sc.nextInt();
			for(int j=0;j<count;++j) {
				opOrder[index++] = i+1;
			}
		}
		dfs(0);
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		for (String s : set) {
			long sum = numbers[0];
			for(int i=0;i<s.length();++i) {
				switch (s.charAt(i)) {
				case '1':
					sum = sum+numbers[i+1];
					break;
				case '2':
					sum = sum-numbers[i+1];					
					break;
				case '3':
					sum = sum*numbers[i+1];					
					break;
				case '4':
					sum = sum/numbers[i+1];					
					break;
				}
			}
			if(sum<min)min = sum;
			if(sum>max)max = sum;
		}
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int depth) {
		if(depth==N-1) {
			StringBuilder sb=new StringBuilder();
			for (int i : op) {
				sb.append(i);
			}
			set.add(sb.toString());
			return;
		}
		for(int i=0;i<N-1;++i) {
			if(!visited[i]) {
				visited[i] = true;
				op[depth] = opOrder[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
		
	}

}
