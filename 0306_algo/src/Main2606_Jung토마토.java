import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2606_Jung토마토 {

	static int M,N,H;
	static int[][][] map;
	static boolean[][][] visited;
	static int[] dx= {0,0,-1,1,0,0};
	static int[] dy= {1,-1,0,0,0,0};
	static int[] dz= {0,0,0,0,1,-1};
	static ArrayList<int[]> list;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		list = new ArrayList<int[]>();
		for(int k=0;k<H;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					map[k][i][j] = sc.nextInt();
					if(map[k][i][j]==1) {
						int[] t = {i,j,k,0};
						list.add(t);
					}
				}
			}
		}
		int flag = 0;
		for(int k=0;k<H;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(map[k][i][j]==0) {
						flag++;
					}
				}
			}
		}
		
		int result = bfs();
		System.out.println(flag==0?0:result);
		
	}
	private static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<list.size();++i) {
			que.add(list.get(i));
			int[] tt = list.get(i);
			visited[tt[2]][tt[0]][tt[1]]= true;
		}
		while(!que.isEmpty()) {
			int[] c= que.poll();
			
			for(int i=0;i<6;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				int nz = c[2]+dz[i];
				if(nx<0||ny<0||nz<0||nx>=N||ny>=M||nz>=H)continue;
				if(!visited[nz][nx][ny]&&map[nz][nx][ny]==0) {
					map[nz][nx][ny]=c[3]+1;
					visited[nz][nx][ny]=true;
					int[] temp = {nx,ny,nz,c[3]+1};
					que.add(temp);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int k=0;k<H;++k) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(map[k][i][j]==0) {
						return -1;
					}
					if(map[k][i][j]>max)max=map[k][i][j];
				}
			}
		}
		return max;
		
		
	}

}
