import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16954_움직이는미로탈출 {

	static int N=8;
	static int[][][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		map = new int[10][8][8];
		for(int i=0;i<8;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<8;++j) {
				if(temp[j]=='#')map[0][i][j] = 1;
			}
		}
		makeMap();
		int result = bfs();
		System.out.println(result);
		
		
	}
	private static int bfs() {
		boolean[][][] visited = new boolean[9][8][8];
		Queue<int[]> que = new LinkedList<int[]>();
		int[] temp = {7,0,0};
		que.add(temp);
		visited[0][7][0] = true;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			if(c[0]==0&&c[1]==7)return 1;
			int vv = c[2]>7?8:c[2];
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(visited[vv][nx][ny]) continue;
				if(map[vv][nx][ny]==1||map[vv+1][nx][ny]==1)continue;
				visited[vv][nx][ny] = true;
				int[] t = {nx,ny,c[2]+1};
				que.add(t);
			}
		}
		
		return 0;
	}
	private static void makeMap() {
		for(int i=0;i<7;++i) {
			clone(map[i],map[i+1]);
		}
	}
	private static void clone(int[][] arr,int[][] target) {
		for(int i=1;i<8;++i) {
			for(int j=0;j<8;++j) {
				target[i][j]=arr[i-1][j];
			}
		}
		
	}

}
