import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500_테트로미노2 {

	static int N,M;
	static int[][] arr;
	static int result;
 	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				bar(i,j);
				square(i,j);
			}
		}
		
		
		System.out.println(result);
	}
	private static void square(int x, int y) {
		if(x+1<N&&y+1<M) {
			int sum=0;
			sum=arr[x][y]+arr[x+1][y]+arr[x][y+1]+arr[x+1][y+1];
			result = sum>result?sum:result;
		}
	}
	private static void bar(int x, int y) {
		if(y+3<M) {
			int sum = 0;
			for(int i=0;i<4;++i) {
				sum+=arr[x][y+i];
			}
			result = sum>result?sum:result;
		}
		
		if(x+3<N) {
			int sum = 0;
			for(int i=0;i<4;++i) {
				sum+=arr[x+i][y];
			}
			result = sum>result?sum:result;
		}
	}


}
