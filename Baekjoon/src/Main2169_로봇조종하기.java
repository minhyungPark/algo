import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2169_로봇조종하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N+1][M+1];
		for(int i=1;i<=N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=M;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
	}

}
