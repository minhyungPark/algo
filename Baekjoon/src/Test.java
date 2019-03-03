import java.util.Scanner;

public class Test {

	static int N,M;
	static int[] numbers;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		sb = new StringBuilder();
		dfs(0,0);
		System.out.println(sb.toString().trim());
	}
	private static void dfs(int index, int flag) {
		
		if(index==M) {
			for (int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;++i) {
			if((flag&(1<<i))==0){
				numbers[index] = i;
				flag = flag|(1<<i);
				dfs(index+1,(flag));
			}
			
		}
		
	}
}
