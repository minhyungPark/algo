import java.util.HashSet;
import java.util.Scanner;

public class Main2210_숫자판점프 {

	static int[][] map;
	static HashSet<Integer> set;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5];
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		set = new HashSet<>();
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				dfs(1,i,j,map[i][j]);
			}
		}
		System.out.println(set.size());
		sc.close();
	}
	private static void dfs(int index, int x, int y,int num) {
		if(index==6) {
			set.add(num);
			return;
		}
		
		for(int i=0;i<4;++i) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=5||ny>=5)continue;
			dfs(index+1,nx,ny,num*10+map[nx][ny]);
		}
		
	}

}
