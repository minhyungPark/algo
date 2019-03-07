import java.util.Scanner;

public class Main1976_여행가자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=N;++j) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0)map[i][j]=999999999;
				if(i==j)map[i][j] = 1;
			}
		}
		int[] trip = new int[M];
		for(int i=0;i<M;++i) {
			trip[i] = sc.nextInt();
		}
		
		for(int k=1;k<=N;++k) {
			for(int i=1;i<=N;++i) {
				if(i==k)continue;
				for(int j=1;j<=N;++j) {
					if(i==j||j==k)continue;
					if(map[i][j]>map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
			
		}
		boolean flag = true;
		for(int i=0;i<M-1;++i) {
			if(map[trip[i]][trip[i+1]]==999999999) {
				flag = false;
			}
		}
		System.out.println(flag?"YES":"NO");
		

	}

}
