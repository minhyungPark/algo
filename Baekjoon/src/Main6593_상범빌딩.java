import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main6593_상범빌딩 {

	static int[] dx = {0,0,-1,1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static int N,M,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			K=sc.nextInt();
			N=sc.nextInt();
			M=sc.nextInt();
			if(N==0&&M==0&&K==0)break;
			int[][][] map = new int[K][N][M];
			int[] start = new int[4];
			int[] end = new int[3];
			for(int k=0;k<K;++k) {
				for(int i=0;i<N;++i) {
					char[] temp = sc.next().toCharArray();
					for(int j=0;j<M;++j) {
						switch (temp[j]) {
						case '#': map[k][i][j]=-1;break;
						case 'S': start[0]=i;start[1]=j;start[2]=k;break;
						case 'E':end[0]=i;end[1]=j;end[2]=k;break;
						}
					}
				}
			}
			int res = bfs(start,end,map);
			if(res==-1)System.out.println("Trapped!");
			else System.out.println("Escaped in "+res+" minute(s).");
		}

	}
	private static int bfs(int[] start, int[] end, int[][][] map) {
		boolean[][][] visited = new boolean[K][N][M];
		visited[start[2]][start[0]][start[1]]=true;
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			int z = c[2];
			if(x==end[0]&&y==end[1]&&z==end[2]) {
				return c[3];
			}
			for(int i=0;i<6;++i) {
				int nx = x+ dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				if(nx<0||ny<0||nz<0||nx>=N||ny>=M||nz>=K)continue;
				if(visited[nz][nx][ny])continue;
				if(map[nz][nx][ny]==-1)continue;
				visited[nz][nx][ny] = true;
				int[] temp = {nx,ny,nz,c[3]+1};
				que.add(temp);
			}
		}
		return -1;
	}

}
