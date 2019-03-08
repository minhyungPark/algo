import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16137 {

	static int N,M;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		int result = bfs();
		System.out.println(result);
	}
	private static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int[] t = {0,0,0,0};
		
		return 0;
	}

}
