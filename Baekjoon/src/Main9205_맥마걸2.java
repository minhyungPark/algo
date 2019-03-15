import java.util.Scanner;

public class Main9205_맥마걸2 {

	static int N;
	static int[][] map;
	static boolean[] visited;
	static boolean result;
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int[] home = new int[2];
			N = sc.nextInt();
			map = new int[N+1][2];
			visited = new boolean[N+1];
			result = false;
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			for(int i=0;i<N+1;++i) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			dfs(home[0],home[1]);
			System.out.println(result?"happy":"sad");
		}
	}
	private static void dfs(int x, int y) {

		if(x==map[N][0]&&y==map[N][1]) {
			result = true;
			return;
		}
		
		if(result)return;
		
		for(int i=0;i<N+1;++i) {
			if(!visited[i]) {
				int xx = Math.abs(x-map[i][0]);
				int yy = Math.abs(y-map[i][1]);
				if(xx+yy<=1000) {
					visited[i] = true;
					dfs(map[i][0],map[i][1]);
				}
			}
		}
		
	}

}
