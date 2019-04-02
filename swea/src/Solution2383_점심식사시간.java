import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2383_점심식사시간 {

	static int N;
	static int[][] map;
	static ArrayList<int[]> personList;
	static ArrayList<int[]> stair;
	static int[][] dis;
	static int result;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] num;
	static int size;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			map = new int[N][N];
			personList = new ArrayList<>();
			stair = new ArrayList<>();
			result = Integer.MAX_VALUE;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==1) {
						int[] temp = {i,j,0};
						personList.add(temp);
					}else if(map[i][j]>1) {
						int[] temp = {i,j,map[i][j]};
						stair.add(temp);
					}
				}
			}
			size= personList.size();
			dis = new int[2][size];
			num = new int[size];
			for(int i=0;i<2;++i) {
				int[] st = stair.get(i);
				for(int j=0;j<size;++j) {
					int[] p = personList.get(j);
					int d = bfs(p,st);
					dis[i][j]=d;
				}
			}
			dfs(0);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
	private static void dfs(int index) {
		if(index==size) {
			int res = simul();
			if(result>res)result = res;
			return;
		}
		
		for(int i=0;i<2;++i) {
			num[index]=i;
			dfs(index+1);
		}
	}
	private static int simul() {
		int s1 = 0;
		int s2 = 0;
		for(int i=0;i<size;++i) {
			if(num[i]==0)s1++;
			else s2++;
		}
		int[] temp1 = new int[s1];
		int[] temp2 = new int[s2];
		int cnt1=0;
		int cnt2=0;
		for(int i=0;i<size;++i) {
			if(num[i]==0) {
				temp1[cnt1++] = dis[0][i];
			}else{
				temp2[cnt2++] = dis[1][i];
			}
		}
		if(s1>0) Arrays.sort(temp1);
		if(s2>0) Arrays.sort(temp2);
		// 1번계단
		int t1 = go(temp1,stair.get(0)[2]);
		// 2번계단
		int t2 = go(temp2,stair.get(1)[2]);
		int cnt = Math.max(t1, t2);
		
		return cnt;
	}
	private static int go(int[] d,int sec) {
		if(d.length==0)return 0;
		int min =0;
		int num = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		while(true) {
			int s = que.size();
			for(int i=0;i<s;++i) {
				int[] c = que.peek();
				if(min-c[1]==sec)que.poll();
				else break;
			}
			
			for(int i=num;i<d.length;++i) {
				if(min>d[i]&&que.size()<3) {
					int[] t = {i,min};
					que.add(t);
					num++;
				}else break;
			}
			if(num==d.length&&que.isEmpty())break;
			min++;
			if(min>50)break;
		}
		
		return min;
	}
	private static int bfs(int[] start, int[] end) {
		int stx = start[0];
		int sty = start[1];
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[stx][sty]= true;
		int[] t = {stx,sty,0};
		que.add(t);
		while(!que.isEmpty()) {
			int[] c= que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(visited[nx][ny])continue;
				if(nx==end[0]&&ny==end[1])return c[2]+1;
				int[] temp = {nx,ny,c[2]+1};
				que.add(temp);
			}
		}
		
		return 0;
	}

}
