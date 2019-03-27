import java.util.Scanner;

public class Test{
	
	static int N,M;
	static int[][] map;
	static boolean[][] clean;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		clean = new boolean[N][M];
		int[] robot = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		while(true) {
			//1.
			clean[robot[0]][robot[1]]=true;
			/*for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(clean[i][j]) {
						System.out.print("1 ");
					}else if(map[i][j]==1) {
						System.out.print("2 ");
					}else{
						System.out.print("0 ");
					}
				}
				System.out.println();
			}
			System.out.println();*/
			//2.
			boolean flag = false;
			if(true) {
				//1)
				int nd = 0;
				int temp = robot[2];
				for(int i=0;i<4;++i) {
					// 왼쪽을 바라본다.
					nd = (temp+3)%4;
					temp = nd;
					int nx = robot[0]+dx[nd];
					int ny = robot[1]+dy[nd];
					if(nx<0||ny<0||nx>=N||ny>=M)continue;
					if(map[nx][ny]==1||clean[nx][ny])continue;
					flag = true;
					break;
				}
				if(flag) {
					robot[2]=nd;
					robot[0]=robot[0]+dx[nd];
					robot[1]=robot[1]+dy[nd];
					continue;
				}else {
					nd = (robot[2]+2)%4;
					int nx = robot[0]+dx[nd];
					int ny = robot[1]+dy[nd];
					if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==1)break;
					robot[0] = nx;
					robot[1] = ny;
				}
			}
			
			
		}
		int result = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(clean[i][j])result++;
			}
		}
		System.out.println(result);
		
	}
	
}