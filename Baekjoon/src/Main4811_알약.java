
public class Main4811_알약 {

	public static void main(String[] args) {
		long[] dp = new long[31];
		dp[1]=1;
		for(int i=2;i<=30;++i) {
			for(int j=1;j<i;++j) {
				dp[i]+=j*dp[i-j];
			}
			dp[i]+=1;
		}
		System.out.println();

	}

}
