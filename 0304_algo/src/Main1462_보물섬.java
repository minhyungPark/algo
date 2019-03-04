import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1462_보물섬 {

	static int N,M;
	static ArrayList<int[]> list; 
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		list = new ArrayList<int[]>();
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='L') {
					map[i][j] = 0;
					int[] node = {i,j};
					list.add(node);
				}
				else map[i][j] = 1;
			}
		}
		int result = 0;
		for(int i=0;i<list.size();++i) {
			int[][] temp = new int[N][M];
			clone(map,temp);
			int t = bfs(temp,list.get(i)[0],list.get(i)[1]);
			result = t>result?t:result;
		}
		System.out.println(result);
	}
	private static int bfs(int[][] arr, int x, int y) {
		int result = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		int[] temp = {x,y,0};
		arr[x][y] = -1;
		que.offer(temp);
		while(!que.isEmpty()) {
			int[] current = que.poll();
			for(int i=0;i<4;++i) {
				int nx = current[0]+dx[i];
				int ny = current[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(arr[nx][ny]==0) {
					arr[nx][ny] = current[2]+1;
					result = arr[nx][ny]>result?arr[nx][ny]:result;
					int[] t = {nx,ny,current[2]+1};
					que.offer(t);
				}
			}
		}
		return result;
	}
	private static void clone(int[][] arr, int[][] target) {

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				target[i][j] = arr[i][j];
			}
		}
	}
	

}
