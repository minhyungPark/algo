import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16988_baaaduk2 {

	static int N,M;
	static int[][] map;
	static ArrayList<int[]> list;
	static int result;
	static int[][] b;
	static int count;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		list = new ArrayList<int[]>();
		result = 0;
		b = new int[2][2];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j] = sc.nextInt();
			}
		}
		count = 3;
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]==2) {
					bfs1(i,j);
				}
				
			}
		}
		block(0,-1);
		System.out.println(result);
	}
	private static void bfs1(int x, int y) {
		
		Queue<int[]> que = new LinkedList<int[]>();
		int[] current = {x,y};
		map[x][y] = count;
		list.add(current);
		que.offer(current);
		while(!que.isEmpty()) {
			int[] t = que.poll();
			for(int i=0;i<4;++i) {
				int nx = t[0]+dx[i];
				int ny = t[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(map[nx][ny]==2) {
					map[nx][ny] = count;
					int[] temp = {nx,ny};
					que.offer(temp);
				}
			}
		}
		count++;
		
	}
	private static void block(int depth,int index) {
		if(depth==2) {
			int sum = 0;
			int[][] temp = new int[N][M];
			clone(map, temp);
			for(int j=0;j<2;++j) {
				temp[b[j][0]][b[j][1]]=1;
			}
//			System.out.println();
			for(int i=0;i<list.size();++i) {
				sum+= bfs(temp,list.get(i)[0],list.get(i)[1]);
			}
			result = sum>result?sum:result;
			return;
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(i*10+j<=index)continue;
				if(map[i][j]!=0)continue;
				b[depth][0] = i;
				b[depth][1] = j;
				block(depth+1,i*10+j);
			}
			
		}
		
		
	}
	private static int bfs(int[][] arr,int x,int y) {
		
		int size = 1;
		int cnt = arr[x][y];
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t = {x,y};
		que.offer(t);
		arr[x][y] = -1*cnt;
		while(!que.isEmpty()) {
			int[] current = que.poll();
			for(int i=0;i<4;++i) {
				int nx = current[0]+dx[i];
				int ny = current[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(arr[nx][ny]==0)return 0;
				if(arr[nx][ny]==cnt) {
					arr[nx][ny]=-1*cnt;
					int[] temp = {nx,ny};
					que.offer(temp);
					size++;
				}
			}
			
		}
		return size;
		
	}
	private static void clone(int[][] arr,int[][] target) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				target[i][j] = arr[i][j];
			}
		}
	}

}
