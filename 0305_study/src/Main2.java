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
		map[robot[0]][robot[1]]=5;
		int x= robot[0],y= robot[1],d= robot[2],nd,nx,ny;
		while(true) {
			
			nd = (d+3)%4;
			nx = x + dx[nd];
			ny = y + dy[nd];
			int f1=0,f2=0;
			for(int i=0;i<4;++i) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				if(nextX<0||nextY<0||nextX>=N||nextY>=M) {
					f1++;
					continue;
				}
				if(map[nextX][nextY]==1) {
					f1++;
				}else if(map[nextX][nextY]==5) {
					f1++;
					f2++;
				}
			}
			if(f1==4&&f2==0)break;
			else if(f1==4) {
				int temp=nd;
				int nextd=(nd+1)%4;
				int nextX = x+dx[nextd];
				int nextY = y+dy[nextd];
				if(nextX<0||nextY<0||nextX>=N||nextY>=M) {
					break;
				}
				if(map[nextX][nextY]==1)break;
				x=nextX;y=nextY;d=temp;
				continue;
			}
			if(nx<0||ny<0||nx>=N||ny>=M) {
				d=nd;
				continue;
			}
			if(map[nx][ny]==0) {
				map[nx][ny]=5;
				x=nx;y=ny;d=nd;
				continue;
			}
			if(map[nx][ny]==5) {
				d=nd;
				continue;
			}
			d=nd;
//			for (int[] i : map) {
//				for (int j : i) {
//					System.out.print(j+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int result = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==5)result++;
			}
		}
		System.out.println(result);
		
		
	}

}
