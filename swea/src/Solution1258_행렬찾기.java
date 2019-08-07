import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1258_행렬찾기 {

	static int N;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static ArrayList<int[]> list;
	static ArrayList<int[]> list1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			map = new int[N][N];
			check = new boolean[N][N];
			list = new ArrayList<int[]>();
			list1 = new ArrayList<int[]>();
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 10;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]!=0&&!check[i][j]) {
						bfs(i,j,cnt++);
						int[] temp = {i,j};
						list.add(temp);
					}
				}
			}
			for(int k=0;k<list.size();++k) {
				int[] temp = list.get(k);
				int xx=0;
				int yy=0;
				for(int i=temp[0];i<N;++i) {
					if(map[i][temp[1]]==10+k) {
						xx++;
					}
				}					
				for(int i=temp[1];i<N;++i) {
					if(map[temp[0]][i]==10+k) {
						yy++;
					}
				}
				int[] tt = {xx,yy};
				list1.add(tt);
			}
			Collections.sort(list1, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int x = o1[0]*o1[1];
					int y = o2[0]*o2[1];
					if(x==y)return o1[0]-o2[0];
					return x-y;
				}
			});
			
			System.out.print("#"+t+" "+list1.size()+" ");
			for(int i=0;i<list1.size();++i) {
				System.out.print(list1.get(i)[0]+" "+list1.get(i)[1]+" ");
			}
			System.out.println();
		}

	}
	private static void bfs(int x, int y,int count) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t = {x,y};
		check[x][y] = true;
		que.add(t);
		map[x][y] = count;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx= c[0]+dx[i];
				int ny= c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(!check[nx][ny]&&map[nx][ny]!=0) {
					check[nx][ny] = true;
					int[] temp = {nx,ny};
					map[nx][ny] = count;
					que.offer(temp);
				}
			}
		}
	}
}
