import java.util.Scanner;

public class Main12865_평범한배낭 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] pro = new int[N+1][2];
		for(int i=1;i<=N;++i) {
			pro[i][0] = sc.nextInt();
			pro[i][1] = sc.nextInt();
		}
		int[][] dp = new int[N+1][100001];
		
		for(int i=1;i<N+1;++i) {
			for(int j=0;j<=K;++j) {
				if(pro[i][0]>j)dp[i][j]=dp[i-1][j];
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-pro[i][0]]+pro[i][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
