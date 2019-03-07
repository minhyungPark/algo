import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main3055_탈출 {

	static int N,M;
	static int[][] map;
	static ArrayList<int[]> wList;
	static boolean[][] visited;
	static int[] start;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		wList = new ArrayList<>();
		start = new int[4];
		int[] end = new int[2];
		for(int i=0;i<N;++i) {
			char[] c = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				if(c[j]=='*') {
					map[i][j]=2;
					int[] temp = {i,j,2,0};
					wList.add(temp);
				}
				else if(c[j]=='X')map[i][j]=-1;
				else if(c[j]=='D') {
					map[i][j]=10;
					end[0] = i;
					end[1] = j;
				}
				else if(c[j]=='S') {
					map[i][j]=1;
					start[0] = i;
					start[1] = j;
					start[2] = 1;
					start[3] = 0;
				}
			}
		}
		int result = bfs();
		System.out.println(result<0?"KAKTUS":result);
	}
	private static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<wList.size();++i) {
			que.add(wList.get(i));
			visited[wList.get(i)[0]][wList.get(i)[1]]=true;
		}
		que.add(start);
		visited[start[0]][start[1]]=true;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(map[nx][ny]==10&&c[2]==1) {
					return c[3]+1;
				}
				if(!visited[nx][ny]&&map[nx][ny]==0) {
					int[] temp = {nx,ny,c[2],c[3]+1};
					visited[nx][ny] = true;
					que.add(temp);
				}
			}
		}
		return -1;
	}

}
