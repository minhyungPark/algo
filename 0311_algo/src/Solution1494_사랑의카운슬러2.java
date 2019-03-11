import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1494_사랑의카운슬러2 {

	static int N;
	static int[][] ji;
	static boolean[] visited;
	static int[] vec;
	static long[][] vector;
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			N = Integer.parseInt(bf.readLine());
			ji = new int[N][2];
			StringTokenizer st = null;
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(bf.readLine());
				ji[i][0] = Integer.parseInt(st.nextToken());
				ji[i][1] = Integer.parseInt(st.nextToken());
			}
			vec = new int[N];
			vector = new long[N/2][2];
			visited = new boolean[N];
			result = Long.MAX_VALUE;
			dfs(0);
			System.out.println("#"+t+" "+result);
		}
	}
	private static void dfs(int depth) {
		if(depth==N) {
			for(int i=0;i<N/2;++i) {
				vector[i][0] = ji[vec[i]][0]-ji[vec[N-i-1]][0];
				vector[i][1] = ji[vec[i]][1]-ji[vec[N-i-1]][1];
			}
			long[] temp = {0,0};
			for(int i=0;i<N/2;++i) {
				temp[0]+=vector[i][0];
				temp[1]+=vector[i][1];
			}
			long ans = 0;
			ans = temp[0]*temp[0]+temp[1]*temp[1];
			if(result>ans)result = ans;
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(!visited[i]) {
				visited[i] = true;
				vec[depth] = i;
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
	}

}
