import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2146_다리만들기 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		String[] s= null;
		for(int i=0;i<N;++i) {
			s = bf.readLine().split(" ");
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		int numb = 2;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(!visited[i][j]&&map[i][j]==1) {
					bfs(i,j,numb++);
				}
			}
		}
		
	}
	private static void bfs(int x, int y,int num) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t= {x,y};
		map[x][y] = num;
		visited[x][y] = true;
		que.add(t);
		while(!que.isEmpty()) {
			int[] c= que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(!visited[nx][ny]&&map[nx][ny]==1) {
					visited[nx][ny] = true;
					map[nx][ny] = num;
					int[] temp = {nx,ny};
					que.add(temp);
				}
			}
			
		}
		
	}

}
