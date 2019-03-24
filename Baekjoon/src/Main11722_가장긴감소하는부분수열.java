import java.util.Arrays;
import java.util.Scanner;

public class Main11722_가장긴감소하는부분수열 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0;i<N;++i) {
			a[i]=sc.nextInt();
		}
		int[] dp = new int[N+1];
		dp[0] = 1;
		for(int i=1;i<N;++i) {
			dp[i] = 1;
			for(int j=0;j<i;++j) {
				if(a[i]<a[j]&&dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
				}
			}
			
		}
		int max=0;
		for(int i=0;i<N;++i) {
			if(dp[i]>max)max=dp[i];
		}
		System.out.println(max);
		
	}

}
