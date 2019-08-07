import java.util.Scanner;

public class Solution5213_진수 {

	static boolean[] prime;
	static int M = 1000000;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		prime = new boolean[M+1];
		dp = new int[M+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 1;
		dp[5] = 6;
		dp[6] = 4;
		makePrime();
		for(int i=7;i<=M;++i) {
			if(dp[i]!=0)continue;
			if(!prime[i]) {
				dp[i] = 1+i;
			}else if(i%2==0) {
				dp[i] = dp[i/2];
			}else {
				int key = 0;
				for(int j=i;j>0;--j) {
					if(!prime[j]&&i%j==0) {
						key = j;
						break;
					}
				}
				dp[i] = dp[key]+i;
			}
		}
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int L = sc.nextInt();
			int R = sc.nextInt();
			long sum = 0;
			for(int i=L;i<=R;++i) {
				sum += dp[i];
			}
			System.out.println("#"+t+" "+sum);
		}
		
	}
	private static void makePrime() {
		for(int j=2;j<=M;++j) {
			if(!prime[j]) {
				int i=j;
				i=i+i;
				while(i<=M) {
					if(!prime[i]) {
						prime[i]=true;
					}
					i=i+i;
				}
				
			}
		}
	}

}
