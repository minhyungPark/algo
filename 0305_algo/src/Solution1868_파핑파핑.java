import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1868_파핑파핑 {
	
	static int[][] map;
	static int N;
	static int[] dx= {0,0,-1,1,1,1,-1,-1};
	static int[] dy= {1,-1,0,0,-1,1,1,-1};
	static boolean[][] check;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			result = 0;
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			for(int i=0;i<N;++i) {
				char[] temp = bf.readLine().toCharArray();
				for(int j=0;j<N;++j) {
					if(temp[j]=='*')map[i][j]=-1;
				}
			}
			
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==0) {
						int cnt=0;
						for(int k=0;k<8;++k) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							if(nx<0||ny<0||nx>=N||ny>=N)continue;
							if(map[nx][ny]==-1)++cnt;
						}
						map[i][j] = cnt;
					}
				}
			}
			check = new boolean[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==0&&!check[i][j]) {
						bfs(i,j);
					}
				}
			}
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(!check[i][j]&&map[i][j]!=-1)result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	
	
	private static void bfs(int x, int y) {
		check[x][y] = true;
		Queue<int[]> que = new LinkedList<>();
		int[] t = {x,y};
		result++;
		que.offer(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			if(map[c[0]][c[1]]!=0)continue;
			for(int i=0;i<8;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(!check[nx][ny]) {
					if(map[nx][ny]==0||(map[c[0]][c[1]]==0||map[nx][ny]!=-1)) {
						int[] temp = {nx,ny};
						check[nx][ny] = true;
						que.offer(temp);
					}
				}
			}
		}
	}
}
