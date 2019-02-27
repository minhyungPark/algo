import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1263_사람네트워크 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];

			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] distance = null;
			boolean[] visited = null;
			int result = Integer.MAX_VALUE;
			for(int n=0;n<N;++n) {
				visited = new boolean[N];
				distance = new int[N];
				for(int i=0;i<N;++i) {
					distance[i] = 99999;
				}
				distance[n] = 0;
				for(int j=0;j<N;++j) {
					int min = Integer.MAX_VALUE;
					int key=0;
					for(int i=0;i<N;++i) {
						if(!visited[i]&&distance[i]<min) {
							min = distance[i];
							key = i;
						}
					}
					visited[key] = true;
					
					for(int i=0;i<N;++i) {
						if(!visited[i]&&arr[key][i]!=0&&distance[i]>1+distance[key]) {
							distance[i] = 1+distance[key];
						}
					}
				}
				int sum=0; 
				for(int i=0;i<N;++i) {
					sum += distance[i];
				}
				if(result>sum)result = sum;
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
