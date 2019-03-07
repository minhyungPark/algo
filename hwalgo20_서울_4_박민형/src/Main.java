import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<int[]> chList;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int total = 0;
		map = new int[N][M];
		chList = new ArrayList<int[]>();
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1)total++;
			}
		}
		bfs(0,0);
		int result = 0;
		int exCnt = 0;
		while(true) {
			int temp = melt();
			if(temp==0) break;
			for(int i=0;i<chList.size();++i) {
				int[] c = chList.get(i);
				map[c[0]][c[1]]=-1;
			}
			for(int i=0;i<chList.size();++i) {
				int[] c = chList.get(i);
				bfs(c[0],c[1]);
			}
			result++;
			exCnt=temp;
			chList.clear();
		}
		System.out.println(result);
		System.out.println(exCnt);
	}

	private static void bfs(int x, int y) {
		visited = new boolean[N][M];
		int[] t = {x,y};
		Queue<int[]> que = new LinkedList<int[]>();
		visited[x][y] = true;
		que.add(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(!visited[nx][ny]&&map[nx][ny]==0) {
					visited[nx][ny] = true;
					map[nx][ny] = -1;
					int[] temp = {nx,ny};
					que.add(temp);
				}
			}
			
		}
		
	}
	private static int melt() {
		int cnt = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==1) {
					cnt++;
					for(int d=0;d<4;++d) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx<0||ny<0||nx>=N||ny>=M)continue;
						if(map[nx][ny]==-1) {
							int[] temp = {i,j};
							chList.add(temp);
						}
					}
				}
			}
		}
		return cnt;
	}
	
	

}
