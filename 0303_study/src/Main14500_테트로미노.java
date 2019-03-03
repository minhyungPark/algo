import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500_테트로미노 {

	static int N,M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
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
		visited = new boolean[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				visited[i][j] = true;
				dfs(i,j,1,arr[i][j]);
				visited[i][j] = false;
				tet(i,j);
			}
		}
		
		System.out.println(result);
	}

	private static void tet(int x, int y) {
		if(x-1>=0&&y+2<M) {
			int sum;
			sum = arr[x][y]+arr[x-1][y+1]+arr[x][y+1]+arr[x][y+2];
			result = sum>result?sum:result;
		}
		
		if(x+1<N&&y+2<M) {
			int sum;
			sum = arr[x][y]+arr[x+1][y+1]+arr[x][y+1]+arr[x][y+2];
			result = sum>result?sum:result;
		}
		if(x+2<N&&y-1>=0) {
			int sum;
			sum = arr[x][y]+arr[x+1][y]+arr[x+2][y]+arr[x+1][y-1];
			result = sum>result?sum:result;
		}
		if(x+2<N&&y+1<M) {
			int sum;
			sum = arr[x][y]+arr[x+1][y]+arr[x+2][y]+arr[x+1][y+1];
			result = sum>result?sum:result;
		}
		
	}

	private static void dfs(int x, int y, int depth,int sum) {

		if(depth==4) {
			result = sum>result?sum:result;
			return;
		}
		for(int i=0;i<4;++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(!visited[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx,ny,depth+1,sum+arr[nx][ny]);
				visited[nx][ny] = false;
			}
		}
		
	}

}
