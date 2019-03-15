import java.util.Scanner;

public class Main9205_맥마걸 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int[] home = new int[2];
			int N = sc.nextInt();
			int[][] map = new int[N+2][2];
			for(int i=0;i<N+2;++i) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			int[][] adj = new int[N+2][N+2];
			for(int i=0;i<N+2;++i) {
				for(int j=0;j<N+2;++j) {
					if(i==j) {
						adj[i][j]=9999999;
						continue;
					}
					int x = Math.abs(map[i][0]-map[j][0]);
					int y = Math.abs(map[i][1]-map[j][1]);
					if(x+y<=1000)adj[i][j]=x+y;
					else adj[i][j]=9999999;
				}
			}
			for(int k=0;k<N+2;++k) {
				for(int i=0;i<N+2;++i) {
					if(i==k)continue;
					for(int j=0;j<N+2;++j) {
						if(j==i||j==k)continue;
						if(adj[i][j]>adj[i][k]+adj[k][j]) {
							adj[i][j] = adj[i][k]+adj[k][j];
						}
					}
				}
			}
			if(adj[0][N+1]==9999999)System.out.println("sad");
			else System.out.println("happy");
			
		}
	}

}
