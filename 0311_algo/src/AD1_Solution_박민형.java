import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AD1_Solution_박민형 {

	static int N;
	static int[][] map;
	// 우,하
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=1;t<=T;++t) {
			N =sc.nextInt();
			map = new int[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j] =sc.nextInt();
				}
			}
			int result = bfs();
			System.out.println("#"+t+" "+result);
		}
	}

	private static int bfs() {
		int cnt = 0;
		Queue<int[]> que = new LinkedList<>();
		// 배열의 0 index : 행 , 1 index: 열, 2 index:방향(0:우,1:하,2:대각)
		if(map[0][1]==0) {
			int[] temp = {0,1,0};
			que.add(temp);
		}
		if(map[1][0]==0) {
			int[] temp = {1,0,1};
			que.add(temp);
		}
		while(!que.isEmpty()) {
			int[] c= que.poll();
			if(c[0]==N-1&&c[1]==N-1) {
				if(c[2]!=2)cnt++;
				continue;
			}
			if(c[2]!=2) {
				int nx = c[0]+dx[c[2]];
				int ny = c[1]+dy[c[2]];
				if(nx>=N||ny>=N)continue;
				if(map[nx][ny]==1)continue;
				int[] temp = {nx,ny,c[2]};
				que.add(temp);
			}else {
				for(int i=0;i<2;++i) {
					int nx = c[0]+dx[i];
					int ny = c[1]+dy[i];
					if(nx>=N||ny>=N)continue;
					if(map[nx][ny]==1)continue;
					int[] temp = {nx,ny,i};
					que.add(temp);
				}
			}
			if(check(c[0],c[1])) {
				int nx = c[0]+1;
				int ny = c[1]+1;
				int[] temp = {nx,ny,2};
				que.add(temp);
			}
		}
		return cnt;
	}
	// 대각방향 갈수 있는지 체크해주는 함수
	private static boolean check(int x, int y) {
		int nx,ny;
		if(x+1>=N||y+1>=N)return false;
		nx = x+1;ny=y;
		if(map[nx][ny]==1)return false;
		nx = x;ny=y+1;
		if(map[nx][ny]==1)return false;
		nx = x+1;ny=y+1;
		if(map[nx][ny]==1)return false;
		return true;
	}

}
