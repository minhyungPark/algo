import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1949_등산로조성 {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N,K;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			int max = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j]=sc.nextInt();
					if(max<map[i][j])max= map[i][j];
				}
			}
			int result = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==max) {
						boolean[][] visited = new boolean[N][N];
						visited[i][j]=true;
						int temp = go(1,i,j,map[i][j],false,visited);
						result = result<temp?temp:result;
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}

	private static int go(int depth, int x, int y, int height,boolean broken, boolean[][] visited) {
		int res = depth;
		for(int i=0;i<4;++i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=N||ny>=N)continue;
			if(visited[nx][ny])continue;
			if(map[nx][ny]<height) {
				visited[nx][ny]=true;
				int temp = go(depth+1,nx,ny,map[nx][ny],broken,visited);
				visited[nx][ny]=false;
				res = res<temp?temp:res;
			}else {
				if(broken)continue;
				for(int k=1;k<=K;++k) {
					if(map[nx][ny]-k>=height)continue;
					visited[nx][ny]=true;
					int temp = go(depth+1,nx,ny,map[nx][ny]-k,true,visited);
					visited[nx][ny]=false;
					res = res<temp?temp:res;
					break;
				}
			}
		}
		return res;
	}

}
