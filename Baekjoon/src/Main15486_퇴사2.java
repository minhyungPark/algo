import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] arr = new int[N][2];
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+51];
		for(int i=0;i<N;++i) {
			int day = arr[i][0];
			int pay = arr[i][1];
			dp[i+day] = Math.max(dp[i+day], dp[i]+pay);
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<=N;++i) {
			if(max<dp[i])max = dp[i];
		}
		System.out.println(max);
		
	}

}
