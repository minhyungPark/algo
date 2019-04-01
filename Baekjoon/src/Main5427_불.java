import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5427_불 {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static int N,M;
	static ArrayList<int[]> fireList;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			fireList = new ArrayList<>();
			int[] start = new int[4];
			for(int i=0;i<N;++i) {
				char[] temp = bf.readLine().toCharArray();
				for(int j=0;j<M;++j) {
					if(temp[j]=='#')map[i][j]=-1;
					else if(temp[j]=='*') {
						int[] tt = {i,j,0,0};
						fireList.add(tt);
					}
					else if(temp[j]=='@') {
						start[0]=i;
						start[1]=j;
						start[2]=1;
					}
				}
			}
			int res = bfs(start);
			System.out.println(res==-1?"IMPOSSIBLE":res);
		}
		
		
	}
	private static int bfs(int[] start) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<fireList.size();++i) {
			int[] t = fireList.get(i);
			visited[t[0]][t[1]]=true;
			que.add(t);
		}
		que.add(start);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M) {
					if(c[2]==1) {
						return c[3]+1;
					}
					continue;
				}
				if(map[nx][ny]==-1)continue;
				if(visited[nx][ny])continue;
				visited[nx][ny]=true;
				int[] temp = {nx,ny,c[2],c[3]+1};
				que.add(temp);
			}
		}
		
		return -1;
	}

}
