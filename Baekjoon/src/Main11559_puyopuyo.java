import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main11559_puyopuyo {

	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N=12;
	static int M=6;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[12][6];
		for(int i=11;i>=0;--i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<6;++j) {
				if(temp[j]=='R')map[i][j]=1;
				else if(temp[j]=='G')map[i][j]=2;
				else if(temp[j]=='B')map[i][j]=3;
				else if(temp[j]=='P')map[i][j]=4;
				else if(temp[j]=='Y')map[i][j]=5;
			}
		}
		ArrayList<Integer>[] put = new ArrayList[6];
		for(int i=0;i<6;++i) {
			put[i] = new ArrayList<Integer>();
		}
		int result = 0;
		while(true) {
			boolean[][] visited = new boolean[N][M];
			ArrayList<int[]> list = null;
			boolean flag =false;
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(!visited[i][j]&&map[i][j]!=0) {
						list = bfs(i,j,visited);
						if(list==null)continue;
						flag = true;
						for(int k=0;k<list.size();++k) {
							int[] c = list.get(k);
							map[c[0]][c[1]]=0;
						}
					}
				}
			}
			if(!flag)break;
			for(int i=0;i<6;++i) {
				put[i].clear();
			}
			for(int j=0;j<6;++j) {
				for(int i=0;i<12;++i) {
					if(map[i][j]!=0) {
						put[j].add(map[i][j]);
					}
				}
			}
			for(int j=0;j<6;++j) {
				for(int i=0;i<12;++i) {
					if(put[j].size()>i) {
						map[i][j]=put[j].get(i);
					}else map[i][j]=0;
				}
			}
			
			result++;
		}
		
		System.out.println(result);
	}
	private static ArrayList<int[]> bfs(int x, int y, boolean[][] visited) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		int color = map[x][y];
		Queue<int[]> que = new LinkedList<int[]>();
		visited[x][y]=true;
		int[] t = {x,y};
		list.add(t);
		que.add(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(map[nx][ny]!=color)continue;
				if(visited[nx][ny])continue;
				visited[nx][ny]= true;
				int[] temp = {nx,ny};
				que.add(temp);
				list.add(temp);
			}
		}
		if(list.size()>=4)return list;
		
		return null;
	}

	
	
	
	
	
	
	
	
}
