import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5427_불 {

	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int i=0;i<N;++i) {
				char[] temp = bf.readLine().toCharArray();
				for(int j=0;j<M;++j) {
					if(temp[j]=='#')map[i][j]=-1;
					if(temp[j]=='#')map[i][j]=-1;
					if(temp[j]=='#')map[i][j]=-1;
					if(temp[j]=='#')map[i][j]=-1;
				}
			}
			
			
		}
		
		
	}

}
