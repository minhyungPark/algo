import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206_벽뿌 {

	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[2][N][M];
		for(int i=0;i<N;++i) {
			char[] temp = bf.readLine().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='1')map[i][j]=1;
			}
		}
		int flag=0;
		if(N==1&&M==1)flag=1;
		int result = 1;
		if(flag!=1) {
			result = bfs();
		}
		System.out.println(result);
		
	}
	private static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		int[] t = {0,0,1,0};
		visited[0][0][0] = true;
		que.add(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			
			for(int i=0;i<4;++i) {
				int nx= c[0]+dx[i];
				int ny= c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(nx==N-1&&ny==M-1)return c[2]+1;
				if(!visited[c[3]][nx][ny]) {
					if(c[3]==0&&map[nx][ny]==1) {
						visited[1][nx][ny]=true;
						int[] temp = {nx,ny,c[2]+1,1};
						que.add(temp);
					}else if(map[nx][ny]==0) {
						visited[c[3]][nx][ny]=true;
						int[] temp = {nx,ny,c[2]+1,c[3]};
						que.add(temp);
					}
				}
			}
		}
		return -1;
	}

}
