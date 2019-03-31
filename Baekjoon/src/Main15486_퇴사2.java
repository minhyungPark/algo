import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] ti = new int[N+1];
		int[] pi = new int[N+1];
		for(int i=1;i<=N;++i) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ti[i] = Integer.parseInt(st.nextToken());
			pi[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+2];
		for(int i=N;i>=0;--i) {
			if(i+ti[i]>N+1)dp[i]=dp[i+1];
			else {
				dp[i]=Math.max(dp[i+ti[i]]+pi[i], dp[i+1]);
			}
		}
		System.out.println(dp[0]);
		
	}

}
