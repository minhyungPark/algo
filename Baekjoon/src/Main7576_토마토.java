import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main7576_토마토 {

	private static class Pair{
		int i,j;
		Pair(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	static int[] dirx = {0,-1,0,1};
	static int[] diry = {1,0,-1,0};
	static boolean[][] visited ;
	static int[][] map ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(N,M);
		
		System.out.println();
		
	}
	private static void bfs(int n, int m) {
		Queue<Pair> que = new LinkedList<Pair>();
		boolean flag = true;
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(map[i][j]==1) {
					que.add(new Pair(i,j));
					visited[i][j] = true;
				}else if(map[i][j]==-1) {
					visited[i][j] = true;
				}
			}
		}
		Pair p = null;
		int nextX,nextY;
		while(!que.isEmpty()) {
			p = que.poll();
			
			for(int d=0;d<4;++d) {
				nextX = p.i+dirx[d];
				nextY = p.j+diry[d];
				
				if(nextX < 0 || nextX>=n ||nextY < 0 || nextY>=m) {
					continue;
				}
				
				if(map[nextX][nextY]==0) {
					map[nextX][nextY] = map[p.i][p.j]+1;
					visited[nextX][nextY] = true;
					que.add(new Pair(nextX,nextY));
				}
			}
		}
		
		for(int i=0;i<n;++i) {
			for(int j=0;j<m;++j) {
				if(!visited[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int[] temp : map) {
			for (int ans : temp) {
				if(ans>max)max=ans;
			}
		}
		System.out.println(max-1);
	}
}
