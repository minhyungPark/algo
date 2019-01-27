import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main2667_단지번호붙이기 {

	static int N,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dirX = {0,0,-1,1};
	static int[] dirY = {1,-1,0,0};
	static ArrayList<Integer> list = new ArrayList<Integer>();
 	private static class Pair{
		int i,j;
		Pair(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	private static void dfs(Pair pair) {
		visited[pair.i][pair.j] = true; 
		cnt++;
		
		for(int i=0;i<4;++i) {
			int nextX = pair.i + dirX[i];
			int nextY = pair.j + dirY[i];
			
			if(nextX<0||nextX>=N||nextY<0||nextY>=N) {
				continue;
			}
			if(map[nextX][nextY]==1&&!visited[nextX][nextY])dfs(new Pair(nextX,nextY));
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		
		  for(int i=0;i<N;++i) {
			  char[] c= bf.readLine().toCharArray();
			  for(int j=0;j<N;++j) { 
				  map[i][j] = c[j]-'0';
			  } 
		  }
		 
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j]==1&&!visited[i][j]) {
					cnt=0;
					dfs(new Pair(i,j));
					list.add(cnt);
				}
			}
		}
		int[] count = new int[list.size()];
		System.out.println(list.size());
		for(int i=0;i<list.size();++i) {
			count[i] = list.get(i);
		}
		Arrays.sort(count);
		for(int i=0;i<count.length;++i) {
			if(count[i]==0)break;
			System.out.println(count[i]);
		}
	}

}
