import java.util.Scanner;

public class Main5557_1학년 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		for(int i=0;i<N;++i) {
			num[i] = sc.nextInt();
		}
		long[][] dp = new long[22][101];
		dp[num[0]][0] = 1;
		for(int j=1;j<N;++j) {
			for(int i=0;i<=21;++i) {
				if(dp[i][j-1]!=0) {
					if(i+num[j]<=20) {
						dp[i+num[j]][j]+=dp[i][j-1];
					}
					if(i-num[j]>=0) {
						dp[i-num[j]][j]+=dp[i][j-1];
					}
				}
			}
			
		}
		System.out.println(dp[num[N-1]][N-2]);
		
	}

}
