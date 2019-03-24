import java.util.Scanner;

public class Main4781_사탕가게 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			double M = sc.nextDouble();
			int m = (int) (M*100);
			if(N==0)break;
			
			int[][] candy = new int[N+1][2];
			for(int i=1;i<=N;++i) {
				candy[i][0] = sc.nextInt();
				candy[i][1] = (int) (sc.nextDouble()*100);
			}
			int[][] dp = new int[N+1][m+1];
			
			for(int i=1;i<=N;++i) {
				for(int j=1;j<=m;++j) {
					if(candy[i][1]<=j) {
						dp[i][j]=Math.max(dp[i-1][j], dp[i][j-candy[i][1]]+candy[i][0]);
					}else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			System.out.println(dp[N][m]);
			
		}
		
	}

}
