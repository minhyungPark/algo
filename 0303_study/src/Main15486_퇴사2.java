import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15486_퇴사2 {

	static int N;
	static int[][] arr;
	static int result;
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
		result = 0;
		dfs(0,0);
		System.out.println(result);
	}
	private static void dfs(int n,int money) {
		if(n>=N) {
			if(result<money)result = money;
			return;
		}
		
		for(int i=n;i<N;++i) {
			int temp = i+arr[i][0];
			if(temp>N) {
				dfs(i+arr[i][0],money);
			}else {
				dfs(i+arr[i][0],money+arr[i][1]);
			}
		}
		
	}

}
