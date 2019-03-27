import java.util.Scanner;

public class Main14501_퇴사 {

	static int N;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for(int i=0;i<N;++i) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int res = dfs(0,0);
		System.out.println(res);
	}
	private static int dfs(int index, int sum) {
		int max = Integer.MIN_VALUE;
		if(index==N) {
			return sum;
		}
		
		if(index>N)return max;
		
		int temp1 = dfs(index+arr[index][0],sum+arr[index][1]);
		int temp2 = dfs(index+1,sum);
		max = Math.max(temp1, Math.max(temp2, max));
		
		return max;
	}

}
