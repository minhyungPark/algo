import java.util.Scanner;

public class Main1149_RGB거리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N+1][3];
		for(int i=1;i<=N;++i) {
			for(int j=0;j<3;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		int[][] dp = new int[N+1][3];
		for(int i=1;i<=N;++i) {
			int[] temp = {Math.min(dp[i-1][1], dp[i-1][2]),Math.min(dp[i-1][0], dp[i-1][2]),Math.min(dp[i-1][0], dp[i-1][1])};
			for(int j=0;j<3;++j) {
				dp[i][j] = temp[j]+map[i][j];
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;++i) {
			if(dp[N][i]<min)min=dp[N][i];
		}
		System.out.println(min);
		sc.close();
	}

}
