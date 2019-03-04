import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16985_maaaze {

	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {-1,1,0,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int[][][] map;
	static int[] roCnt;
	static int result;
	static int[] pile;
	static boolean[] visited;
	private static class Node{
		int x,y,z,cnt;
		Node(int x,int y,int z,int cnt){
			this.x = x;
			this.y = y;
			this.z = z;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[5][5][5];
		for(int k=0;k<5;++k) {
			for(int i=0;i<5;++i) {
				for(int j=0;j<5;++j) {
					map[k][i][j] = sc.nextInt();
				}
			}
		}
		
		
		result = Integer.MAX_VALUE;
		roCnt = new int[5];
		pile = new int[5];
		visited = new boolean[5];
		dfs(0);
		if(result == Integer.MAX_VALUE) result = -1;
		System.out.println(result);
	}
	private static void dfs(int index) {
		if(index==5) {
			int[][][] temp = new int[5][5][5];
			for(int i=0;i<5;++i) {
				clone(map[i],temp[i]);
			}
			for(int i=0;i<5;++i) {
				rotate(temp[i],roCnt[i]);
			}
			permutation(temp,0);
			return;
		}
		
		for(int i=0;i<4;++i) {
			roCnt[index]=i;
			dfs(index+1);
		}
		
	}
	private static void permutation(int[][][] arr,int depth) {
		if(depth==5) {
			int[][][] temp = new int[5][5][5];
			for(int i=0;i<5;++i) {
				clone(arr[i],temp[pile[i]]);
			}
			int t =bfs(temp);
			if(t!=-1) {
				result = t<result?t:result;
			}
			return;
		}
		
		for(int i=0;i<5;++i) {
			if(!visited[i]) {
				visited[i] = true;
				pile[depth] = i;
				permutation(arr,depth+1);
				visited[i] = false;
			}
			
		}
		
		
	}
	private static int bfs(int[][][] temp) {
		if(temp[0][0][0]==0)return -1;
		Queue<Node> que = new LinkedList<Node>();
		que.offer(new Node(0,0,0,0));
		while(!que.isEmpty()) {
			Node c = que.poll();
			for(int i=0;i<6;++i) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				int nz = c.z + dz[i];
				if(nx>=5||ny>=5||nz>=5||nx<0||ny<0||nz<0)continue;
				if(temp[nx][ny][nz]==1) {
					temp[nx][ny][nz] = c.cnt+1;
					que.offer(new Node(nx, ny, nz, c.cnt+1));
				}
			}
		}
		if(temp[4][4][4]==0||temp[4][4][4]==1)return -1;
		return temp[4][4][4];
	}
	private static void rotate(int[][] arr,int N) {
		for(int n=0;n<N;++n) {
			for(int i=1;i<=2;++i) {
				int temp = arr[1][i];
				arr[1][i] = arr[4-i][1];
				arr[4-i][1] = arr[3][4-i];
				arr[3][4-i] = arr[i][3];
				arr[i][3] = temp;
			}
			for(int i=0;i<4;++i) {
				int temp = arr[0][i];
				arr[0][i] = arr[4-i][0];
				arr[4-i][0] = arr[4][4-i];
				arr[4][4-i] = arr[i][4];
				arr[i][4] = temp;
			}
		}
	
	}

	private static void clone(int[][] arr, int[][] target) {

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				target[i][j] = arr[i][j];
			}
		}
	}
	
}
