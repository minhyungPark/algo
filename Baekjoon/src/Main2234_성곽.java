import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2234_성곽 {
	
	static int N,M;
	static int[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		arr = new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		int cnt = 1;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(arr[i][j]==0) {
					bfs(i,j,cnt++);
				}
			}
		}
		int max1 = Integer.MIN_VALUE;
		int[] area = new int[cnt];
		for(int k=1;k<cnt;++k) {
			int temp = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(arr[i][j]==k)temp++;
				}
			}
			area[k] = temp;
			if(temp>max1)max1=temp;
		}
		int max2 = Integer.MIN_VALUE;
outer:	for(int k=1;k<cnt;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(arr[i][j]==k) {
						boolean[][] visited = new boolean[N][M];
						HashSet<Integer> ss = bfs1(visited,i,j,k);
						int res = area[k];
						for (Integer tt : ss) {
							int temp = res +area[tt];
							if(max2<temp)max2=temp;
						}
						continue outer;
					}
				}
			}
		}
		System.out.println(cnt-1);
		System.out.println(max1);
		System.out.println(max2);
		sc.close();
	}
	private static HashSet<Integer> bfs1(boolean[][] visited, int xx, int yy, int k) {
		Queue<int[]> que = new LinkedList<int[]>();
		visited[xx][yy]=true;
		int[] t = {xx,yy,0,1,k};
		que.add(t);
		HashSet<Integer> set = new HashSet<Integer>();
		while(!que.isEmpty()) {
			int[] c = que.poll();
			
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(visited[nx][ny])continue;
				if(arr[nx][ny]==k) {
					visited[nx][ny]=true;
					int[] temp = {nx,ny,c[2],c[3]+1,c[4]};
					que.add(temp);
				}else {
					set.add(arr[nx][ny]);
				}
			}
		}
		return set;
	}
	private static void bfs(int xx, int yy, int k) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t = {xx,yy};
		que.add(t);
		arr[xx][yy] = k;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			for(int i=0;i<4;++i) {
				if((map[x][y]&(1<<i))!=0)continue;
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(arr[nx][ny]!=0)continue;
				arr[nx][ny]=k;
				int[] temp = {nx,ny};
				que.add(temp);
			}
		}
	}
}
