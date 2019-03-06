import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,M;
		N = sc.nextInt();
		M = sc.nextInt();
		int[] robot = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
		int[][] map = new int[N][M];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		boolean[][] clean = new boolean[N][M];
		clean[robot[0]][robot[1]]=true;
		int x;
		int y;
		int d;
		int nd;
		int nx;
		int ny;
		while(true) {
			x = robot[0];
			y = robot[1];
			d = robot[2];
			int flag = 0;
			for(int i=0;i<4;++i) {
				int nextX = x +dx[i];
				int nextY = y +dy[i];
				if(nextX<0||nextY<0||nextX>=N||nextY>=M) {
					flag++;continue;
				}else if(map[nextX][nextY]==1||clean[nextX][nextY]) {
					flag++;continue;
				}
				
			}
			
			
			nd = (d-1)<0?3:d-1;
			nx = x + dx[nd];
			ny = y + dy[nd];
			if(nx<0||ny<0||nx>=N||ny>=M) {
				
				
				
			}
			
			
		}
		
		
	}

}
