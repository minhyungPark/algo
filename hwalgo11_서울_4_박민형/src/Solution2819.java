
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2819 {
	
	static int[][] numbers;
	static int N=7;
	static int[] results = new int[7];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static HashSet<String> set;
 	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st =null;
		for(int t=1;t<=T;++t) {
			set = new HashSet<String>();
			numbers = new int[4][4];
			for(int i=0;i<4;++i) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0;j<4;++j) {
					numbers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<4;++i) {
				for(int j=0;j<4;++j) {
					results[0] = numbers[i][j];
					dfs(i,j,1);
				}
			}
			System.out.println("#"+t+" "+set.size());
			
		}
	}
	private static void dfs(int x,int y,int index) {
		if(index==N) {
			String s = Arrays.toString(results);
			set.add(s);
			return;
		}
		
		
		for(int i=0;i<4;++i) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX<0||nextY<0||nextX>=4||nextY>=4) {
				continue;
			}
			results[index] = numbers[nextX][nextY];
			dfs(nextX,nextY,index+1);
			
		}
		
	}

}
