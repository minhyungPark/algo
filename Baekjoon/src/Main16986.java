import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16986 {

	static int N,M;
	static int[][] arr;
	static int[] b,c;
	static int[] cnt;
	static boolean[] a;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		cnt = new int[N];
		a = new boolean[N+1];
		b = new int[20];
		c = new int[20];
		for(int i=1;i<=N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;++i) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;++i) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1,2,0,0,0,0,0);
		System.out.println(result);
	}
	private static void dfs(int win,int nonP,int bcnt, int ccnt, int awin,int bwin,int cwin) {
		if(awin==M||bwin==M||cwin==M) {
			if(awin==M)result=1;
			return;
		}
//		if(result==1)return;
		
		if(win!=1&&nonP!=1) {		// 경희 민호 대결
			int bb = b[bcnt];
			int cc = c[ccnt];
			int arrInfo = arr[bb][cc];
			if(arrInfo==2) {
				dfs(2,1,bcnt+1,ccnt+1,awin,bwin+1,cwin);
			}else {
				dfs(3,1,bcnt+1,ccnt+1,awin,bwin,cwin+1);
			}
			return;
		}
		
		for(int i=1;i<=N;++i) {
			if(!a[i]) {
				a[i] = true;
				if(nonP==2||win==2) {		// 지우 경희 대결
					int bb = b[bcnt];
					int arrInfo = arr[i][bb];
					if(arrInfo==2) {
						dfs(1,3,bcnt+1,ccnt,awin+1,bwin,cwin);
					}else {
						dfs(2,3,bcnt+1,ccnt,awin,bwin+1,cwin);
					}
				}else {						// 지우 민호 대결
					int cc = c[ccnt];
					int arrInfo = arr[i][cc];
					if(arrInfo==2) {
						dfs(1,2,bcnt,ccnt+1,awin+1,bwin,cwin);
					}else {
						dfs(3,2,bcnt,ccnt+1,awin,bwin,cwin+1);
					}
				}
				a[i] = false;
			}
		}
		
	}

}
