import java.util.ArrayList;
import java.util.Scanner;

public class Main16959_체스판여행1 {

	static int N;
	static int[][] map;
	static int[] kdx = {-2,-2,2,2,-1,-1,1,1};
	static int[] kdy = {-1,1,-1,1,-2,2,-2,2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		ArrayList<int[]> list = new ArrayList<int[]>();
		int[] tt = {0,0};
		list.add(tt);
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int k=1;k<=N*N;++k) {
outer:		for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==k) {
						int[] temp = {i,j};
						list.add(temp);
						break outer;
					}
				}
			}
		}
		int[][] dp = new int[N*N+1][3];
		for(int i=2;i<=N*N;++i) {
			int[] c = list.get(i);
			int[] ex = list.get(i-1);
			if(c[0]==ex[0]||c[1]==ex[1]) {
				dp[i][0]=Math.min(Math.min(dp[i-1][0]+1, dp[i-1][1]+2), dp[i-1][2]+2);
			}else {
				dp[i][0]=Math.min(Math.min(dp[i-1][0]+2, dp[i-1][1]+3), dp[i-1][2]+3);
			}
			
			if(c[0]-c[1]==ex[0]-ex[1]||c[0]+c[1]==ex[0]+ex[1]) {
				dp[i][1]=Math.min(Math.min(dp[i-1][0]+2, dp[i-1][1]+1), dp[i-1][2]+2);
			}else if(Math.abs((c[0]-c[1])-(ex[0]-ex[1]))%2==0||Math.abs((c[0]+c[1])-(ex[0]+ex[1]))%2==0) {
				dp[i][1]=Math.min(Math.min(dp[i-1][0]+3, dp[i-1][1]+2), dp[i-1][2]+3);
			}else {
				dp[i][1]=9999;
			}
			
			boolean f1 = false;
			boolean f2 = false;
			boolean f3 = false;
			for(int d=0;d<8;++d) {
				int nx = ex[0]+kdx[d];
				int ny = ex[1]+kdy[d];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(nx==c[0]&&ny==c[1]) {
					f1= true;
					break;
				}else {
					for(int dd=0;dd<8;++dd) {
						int nnx = nx + kdx[dd];
						int nny = ny + kdy[dd];
						if(nnx<0||nny<0||nnx>=N||nny>=N)continue;
						if(nnx==c[0]&&nny==c[1]) {
							f2 = true;
							break;
						}else {
							for(int ddd=0;ddd<8;++ddd) {
								int nnnx = nnx +kdx[ddd];
								int nnny = nny +kdy[ddd];
								if(nnnx==c[0]&&nnny==c[1]) {
									f3 = true;
									break;
								}
							}
						}
					}
				}
			}
			if(f1) {
				dp[i][2] = Math.min(Math.min(dp[i-1][0]+2, dp[i-1][1]+2), dp[i-1][2]+1);
			}else if(!f1&&f2) {
				dp[i][2] = Math.min(Math.min(dp[i-1][0]+3, dp[i-1][1]+3), dp[i-1][2]+2);
			}else if(!f1&&!f2&&f3){
				dp[i][2] = Math.min(Math.min(dp[i-1][0]+4, dp[i-1][1]+4), dp[i-1][2]+3);
			}else {
				dp[i][2] = 9999;
			}
		}
		int min = 9999;
		for(int i=0;i<3;++i) {
			if(min>dp[N*N][i])min=dp[N*N][i];
		}
		System.out.println(min);
	}

}
