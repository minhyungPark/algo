import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main15684_사다리조작 {

	static int N,M,H;
	static int[][] map;
	static int[] dy = {1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H+2][N+2];
		for(int i=0;i<M;++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		int res = dfs(0,0,1,1);
		
		/*
		 * for (int[] m : map) { for (int i : m) { System.out.print(i+" "); }
		 * System.out.println(); }
		 */
		if(res==Integer.MAX_VALUE)res=-1;
		System.out.println(res);

	}
	private static int dfs(int i, int cnt, int x, int y) {
		int res = Integer.MAX_VALUE;
		if(y==N) {
			for(int k=1;k<=N;++k) {
				if(!bfs(k))return res;
			}
			return cnt;
		}
		if(cnt>3)return res;
		
		if(map[x][y]==0&&map[x][y+1]==0&&cnt<3) {
			map[x][y]=1;
			map[x][y+1]=2;
			if(x==H) {
				int temp =dfs(i,cnt+1,1,y+1);
				res = Math.min(temp, res);
			}else{
				int temp = dfs(i,cnt+1,x+1,y);
				res = Math.min(temp, res);
			}
			map[x][y]=0;
			map[x][y+1]=0;
		}
		if(x==H) {
			int temp =dfs(i,cnt,1,y+1);
			res = Math.min(temp, res);
		}else if(x!=H){
			int temp = dfs(i,cnt,x+1,y);
			res = Math.min(temp, res);
		}
		
		return res;
	}
	private static boolean bfs(int xx) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] temp = {0,xx,0};
		que.offer(temp);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			if(c[0]==H+2) {
				if(c[1]==xx)return true;
				else return false;
			}
			if(map[x][y]!=0&&c[2]==0) {
				if(map[x][y]==1) {
					int[] t = {x,y+1,1};
					que.offer(t);
				}else {
					int[] t = {x,y-1,1};
					que.offer(t);
				}
			}else {
				int[] t = {x+1,y,0};
				que.offer(t);
			}
		}
		
		
		return false;
	}
	
	

}
