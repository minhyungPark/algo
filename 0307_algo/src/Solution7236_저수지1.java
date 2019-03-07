import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7236_저수지1 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			int N;
			int[][] map;
			int[] dx = {0,0,1,-1,1,-1,-1,1};
			int[] dy = {1,-1,0,0,1,-1,1,-1};
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			StringTokenizer st= null;
			for(int i=0;i<N;++i) {
				st=new StringTokenizer(bf.readLine());
				for(int j=0;j<N;++j) {
					if(st.nextToken().equals("W"))map[i][j]=1;
				}
			}
			int result = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]==1) {
						int cnt = 0;
						for(int d=0;d<8;++d) {
							int nx = i+dx[d];
							int ny = j+dy[d];
							if(nx<0||ny<0||nx>=N||ny>=N)continue;
							if(map[nx][ny]==1)cnt++;
						}
						if(cnt==0)cnt=1;
						result = cnt>result?cnt:result;
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
