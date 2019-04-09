import java.util.ArrayList;
import java.util.Scanner;

public class Main16959_체스판여행1 {

	static int N;
	static int[][] map;
	static int[] kdx = {-2,-2,2,2,-1,-1,1,1};
	static int[] kdy = {-1,1,-1,1,-2,2,-2,2};
	static int[] k1dx = {-4,-4,-4,-3,-3,-3,-3,-2,-2,-2,-1,-1,-1,-1,0,0,0,0,1,1,1,1,2,2,2,3,3,3,3,4,4,4};
	static int[] k1dy = {-2,0,2,-3,-1,1,3,-4,0,4,-3,-1,1,3,-4,-2,2,4,-3,-1,1,3,-4,0,4,-3,-1,1,3,-2,0,2};
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
			for(int d=0;d<8;++d) {
				int nx = ex[0]+kdx[d];
				int ny = ex[1]+kdy[d];
				if(nx==c[0]&&ny==c[1]) {
					f1= true;
					break;
				}
			}
			for(int d=0;d<k1dx.length;++d) {
				int nx = ex[0]+k1dx[d];
				int ny = ex[1]+k1dy[d];
				if(nx==c[0]&&ny==c[1]) {
					f2=true;
					break;
				}
			}
			if(f1) {
				dp[i][2] = Math.min(Math.min(dp[i-1][0]+2, dp[i-1][1]+2), dp[i-1][2]+1);
			}else if(f2) {
				dp[i][2] = Math.min(Math.min(dp[i-1][0]+3, dp[i-1][1]+3), dp[i-1][2]+2);
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
