import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test{

	public static void main(String[] args) {
		
		long[] dp = new long[100001];
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3;i<=10000;++i) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println();
	}

}
