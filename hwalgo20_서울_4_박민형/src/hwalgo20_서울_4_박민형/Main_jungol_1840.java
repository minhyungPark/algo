package hwalgo20_서울_4_박민형;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_jungol_1840 {
	
	static int N,M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs(0,0);
		Queue<int[]> cque = new LinkedList<>();
		
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==1) {
					boolean flag = meltingCheck(i,j);
					if(flag) {
						int[] temp = {i,j};
						cque.add(temp);
					}
				}
			}
		}
		
	}

	private static boolean meltingCheck(int x, int y) {
		for(int i=0;i<N;++i) {
			int nx= x+dx[i];
			int ny = y+dy[i];
			if(map[nx][ny]==-1)return true;
		}
		
		return false;
	}

	private static void bfs(int x, int y) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		int[] t= {x,y};
		que.add(t);
		visited[x][y] = true;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(!visited[nx][ny]&&map[nx][ny]==0) {
					map[nx][ny] = -1;
					visited[nx][ny] = true;
					int[] temp = {nx,ny};
					que.add(temp);
				}
			}
		}
		
	}

}
