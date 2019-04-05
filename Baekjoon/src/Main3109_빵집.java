import java.util.Scanner;

public class Main3109_빵집 {

	static int N,M;
	static int[][] map;
	static int[] dx = {-1,0,1};
	static int result;
	static boolean flag;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='x')map[i][j]=-1;
			}
		}
		min = Integer.MAX_VALUE;
		for(int j=0;j<M;++j) {
			int temp = 0;
			for(int i=0;i<N;++i) {
				if(map[i][j]==0)temp++;
			}
			if(temp<min)min = temp;
		}
		result = 0;
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;++i) {
			flag = false;
			dfs(i,0,visited);
		}
		System.out.println(result);
		
		sc.close();
	}
	private static void dfs(int index, int width, boolean[][] visited) {
		if(width==M-1) {
			result++;
			flag = true;
			return;
		}
		for(int i=0;i<3;++i) {
			int nx = index+dx[i];
			if(nx<0||nx>=N)continue;
			if(visited[nx][width+1]||map[nx][width+1]==-1)continue;
			visited[nx][width+1] = true;
			dfs(nx,width+1,visited);
			if(flag)return;
//			if(!flag)visited[nx][width+1]=false;
		}
		
	}

}
