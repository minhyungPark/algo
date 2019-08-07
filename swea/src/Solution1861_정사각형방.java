import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1861_정사각형방 {

	static int N;
	static int[][] map;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;++t) {
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			arr = new int[N][N];
			StringTokenizer st =null; 
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<N;++j) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int r=0,key=Integer.MAX_VALUE;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					int temp =bfs1(i,j,map[i][j]);
					if(r<temp) {
						r=temp;
						key=map[i][j];
					}else if(r==temp) {
						key = map[i][j]<key?map[i][j]:key;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(key).append(" ").append(r).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
	private static int bfs1(int x, int y, int val) {
		Queue<int[]> que = new LinkedList<>();
		int max=0;
		int[] t = {x,y,val,1};
		que.add(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(map[nx][ny]==c[2]+1) {
					int[] temp = {nx,ny,c[2]+1,c[3]+1};
					arr[nx][ny] = c[3]+1;
					que.add(temp);
				}
			}
			max = c[3]>max?c[3]:max;
		}
		return max;
	}

}
