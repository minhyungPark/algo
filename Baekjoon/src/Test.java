import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4;i<=N;++i) {
			dp[i] = (dp[i-2]+dp[i-1])%10007;
		}
		System.out.println(dp[N]);
	}
}
