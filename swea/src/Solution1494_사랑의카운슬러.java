import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1494_사랑의카운슬러 {

	static int N;
	static int[][] ji;
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=T;++t) {
			N = Integer.parseInt(bf.readLine());
			ji = new int[N][2];
			StringTokenizer st = null;
			for(int i=0;i<N;++i) {
				st = new StringTokenizer(bf.readLine());
				ji[i][0] = Integer.parseInt(st.nextToken());
				ji[i][1] = Integer.parseInt(st.nextToken());
			}
			result = Long.MAX_VALUE; 
			dfs(0,0,0);
			System.out.println("#"+t+" "+result);
		}
	}
	private static void dfs(int idx,int count, int flag) {

		if(count==N/2) {
			long x=0;
			long y=0;
			for(int i=0;i<N;++i) {
				if((flag&(1<<i))==0) {
					x+=ji[i][0];
					y+=ji[i][1];
				}else {
					x-=ji[i][0];
					y-=ji[i][1];
				}
			}
			if(x*x+y*y<result) result = x*x+y*y;
			return;
		}
		if(idx==N)return;
		
		dfs(idx+1,count+1,(flag|(1<<idx)));
		dfs(idx+1,count,flag);
		
		
	}

}
