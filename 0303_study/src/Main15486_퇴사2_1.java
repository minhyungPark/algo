import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15486_퇴사2_1 {

	static int N;
	static int[][] arr;
	static int result;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][2];
		StringTokenizer st = null;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1];
		result = 0;
		if(arr[0][0]==1)dp[1] = arr[0][1];
		for(int i=2;i<=N;++i) {
			
			
		}
		System.out.println(result);
	}

}
