import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1113_수영장만들기 {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static int N,M;
	static int result;
	static ArrayList<int[]> list;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int min = 10;
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				map[i][j]=temp[j]-'0';
				if(i==0||i==N-1||j==0||j==M-1)continue;
				if(min>map[i][j]&&map[i][j]!=0)min=map[i][j];
			}
		}
		list = new ArrayList<int[]>();
		for(int i=1;i<N-1;++i) {
			for(int j=1;j<M-1;++j) {
				if(map[i][j]==min) {
					int[] temp= {i,j};
					list.add(temp);
				}
			}
		}
		while(true) {
			visited = new boolean[N][M];
			int temp = result;
			ArrayList<int[]> tList = null;
			for(int i=0;i<list.size();++i) {
				int x = list.get(i)[0];
				int y = list.get(i)[1];
				if(visited[x][y])continue;
				tList = bfs(x,y,min);
				if(tList==null)continue;
				result+=tList.size();
				for(int t=0;t<tList.size();++t) {
					map[tList.get(t)[0]][tList.get(t)[1]]++;
				}
			}
			if(temp==result)break;
			list.clear();
			min++;
			for(int i=1;i<N-1;++i) {
				for(int j=1;j<M-1;++j) {
					if(map[i][j]==min) {
						int[] tt = {i,j};
						list.add(tt);
					}
				}
			}
			
		}
		System.out.println(result);
		sc.close();
	}
	private static ArrayList<int[]> bfs(int x, int y, int min) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		Queue<int[]> que = new LinkedList<int[]>();
		visited[x][y]=true;
		int[] t = {x,y};
		que.add(t);
		list.add(t);
		boolean flag = true;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(nx==0||ny==0||nx==N-1||ny==M-1) {
					if(map[nx][ny]<=min)flag = false;
					continue;
				}
				if(visited[nx][ny])continue;
				if(map[nx][ny]<min) {
					flag = false;
				}
				if(map[nx][ny]==min) {
					int[] temp = {nx,ny};
					visited[nx][ny]=true;
					que.add(temp);
					list.add(temp);
				}
			}
		}
		if(!flag)return null;
		return list;
	}
}
