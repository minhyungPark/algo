import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2458_키순서 {

	static final int INF = 999999;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int M = sc.nextInt();
		StringTokenizer st=null;
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adj = new int[N][N];
		fill(adj);
		int result =0;
		
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
//			int a = sc.nextInt();
//			int b = sc.nextInt();
			adj[a-1][b-1] = 1;
		}
		
		for(int k=0;k<N;++k) {
			for(int i=0;i<N;++i) {
				if(i==k)continue;
				for(int j=0;j<N;++j) {
					if(i==j||j==k)continue;
					if(adj[i][j]>adj[i][k]+adj[k][j]) {
						adj[i][j] = adj[i][k]+adj[k][j];
					}
				}
			}
		}
		for(int i=0;i<N;++i) {
			int temp = 0;
			for(int j=0;j<N;++j) {
				if(i==j)continue;
				if(adj[i][j]!=INF)temp++;
				if(adj[j][i]!=INF)temp++;
			}
			if(temp==N-1)result++;
		}
		System.out.println(result);
		
	}
	private static void fill(int[][] arr) {
		for(int i=0;i<arr.length;++i) {
			for(int j=0;j<arr[0].length;++j) {
				arr[i][j]=INF;
			}
		}
	}

}
