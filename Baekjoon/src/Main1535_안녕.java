import java.util.Scanner;

public class Main1535_안녕 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hp = 100;
		int happy = 0;
		int N = sc.nextInt();
		int[][] an = new int[N+1][2];
		for(int i=1;i<=N;++i) {
			an[i][0] = sc.nextInt();
		}
		for(int i=1;i<=N;++i) {
			an[i][1] = sc.nextInt();
		}
		int[][] dp = new int[N+1][101];
		for(int i=1;i<=N;++i) {
			for(int j=0;j<=100;++j) {
				if(j>an[i][0]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-an[i][0]]+an[i][1]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][100]);
	}

}
