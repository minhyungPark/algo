import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11404_플로이드 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int[][] map = new int[N+1][N+1];
		for(int i=0;i<=N;++i) {
			Arrays.fill(map[i], 222222222);
		}
		StringTokenizer st = null;
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			int tc = Integer.parseInt(st.nextToken());
			if(map[tx][ty]>tc) {
				map[tx][ty] = tc;
//				map[ty][tx] = tc;
			}
		}
		for(int k=1;k<=N;++k) {
			for(int i=1;i<=N;++i) {
				if(k==i)continue;
				for(int j=1;j<=N;++j) {
					if(k==j||j==i)continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j]=map[i][k]+map[k][j];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=N;++j) {
				sb.append(map[i][j]>100000000?0:map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

}
