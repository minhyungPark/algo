import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main14442_벽부수고이동하기2 {

	static int N,M,K;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		M = sc.nextInt();
//		K = sc.nextInt();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;++i) {
			char[] temp = bf.readLine().toCharArray();
//			char[] temp = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='1')map[i][j] = 1;
			}
		}
		int result = bfs();
//		if(N==1&&M==1)result = 1;
		System.out.println(result);
		
		
	}

	private static int bfs() {
		boolean[][][] v = new boolean[K+1][N][M];
		Queue<int[]> que = new LinkedList<int[]>();
		int[] temp = {0,0,0,0};
		v[0][0][0] = true;
		que.offer(temp);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			
			if(c[0]==N-1&&c[1]==M-1) {
				return c[3]+1;
			}
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(map[nx][ny]==0&&!v[c[2]][nx][ny]) {
					v[c[2]][nx][ny] = true;
					int[] t = {nx,ny,c[2],c[3]+1};
					que.offer(t);
				}else if(map[nx][ny]==1&&c[2]<K) {
					if(v[c[2]+1][nx][ny])continue;
					v[c[2]+1][nx][ny] = true;
					int[] t = {nx,ny,c[2]+1,c[3]+1};
					que.offer(t);
				}
			}
		}
		return -1;
	}

}
