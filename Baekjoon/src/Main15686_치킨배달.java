import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main15686_치킨배달 {

	static int N;
	static int[][] map;
	static ArrayList<int[]> home;
	static ArrayList<int[]> chicken;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		map = new int[N][N];
		home = new ArrayList<int[]>();
		chicken = new ArrayList<int[]>();
		int cnt = 1;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1) {
					map[i][j]=cnt++;
					int[] temp = {i,j};
					home.add(temp);
				}else if(map[i][j]==2) {
					map[i][j]=-1;
					int[] temp = {i,j};
					chicken.add(temp);
				}
			}
		}
		int[][] distance = new int[chicken.size()][home.size()];
		for(int i=0;i<chicken.size();++i) {
			int[] c = chicken.get(i);
			int[][] arr = new int[N][N];
			clone(map,arr);
			for(int j=0;j<home.size();++j) {
				int[] dis = bfs(arr,c[0],c[1]);
				distance[i][dis[0]]=dis[1];
			}
			System.out.println();
		}
		Arrays.sort(distance, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int sum1 = 0;
				int sum2 = 0;
				for(int i=0;i<o1.length;++i) {
					sum1+=o1[i];
					sum2+=o2[i];
				}
				return sum1-sum2;
			}
		});
		int result = 0;
		for(int j=0;j<home.size();++j) {
			int min = Integer.MAX_VALUE;
			for(int i=0;i<M;++i) {
				if(min>distance[i][j])min = distance[i][j];
			}
			result+=min;
		}
		System.out.println(result);
		
		
//		int[] disSum = new int[chicken.size()];
//		for(int i=0;i<disSum.length;++i) {
//			int sum = 0;
//			for(int j=0;j<cnt;++j) {
//				sum+=distance[i][j];
//			}
//			disSum[i] = sum;
//		}
//		Arrays.sort(disSum);
		
		
		
		
	}
	
	private static int[] bfs(int[][] arr, int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		visited[x][y] = true;
		int[] tt = {x,y,0};
		que.offer(tt);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			if(arr[c[0]][c[1]]>0) {
				int t = arr[c[0]][c[1]];
				arr[c[0]][c[1]] = 0;
				int[] temp = {t-1,c[2]};
				return temp;
			}
			
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(visited[nx][ny])continue;
				visited[nx][ny] = true;
				int[] temp = {nx,ny,c[2]+1};
				que.offer(temp);
			}
			
		}
		
		return null;
	}

	private static void clone(int[][] arr,int[][] target) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				target[i][j]=arr[i][j];
			}
		}
		
		
	}

}
