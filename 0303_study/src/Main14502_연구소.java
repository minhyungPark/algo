import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502_연구소 {

	private static class Node{
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int N,M;
	static int[][] arr;
	static ArrayList<Node> virus;
	static boolean[][] wallCheck;
	static HashSet<Node[]> wallList;
	static Node[] nodeList;
	static boolean[][] check;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		virus = new ArrayList<Node>();
		wallCheck = new boolean[N][M];
		wallList = new HashSet<Node[]>();
		nodeList = new Node[3];
		result = Integer.MIN_VALUE;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) virus.add(new Node(i,j));
			}
		}
		madeWall(0,-1);
		
		System.out.println(result);
	}
	private static void madeWall(int depth,int index) {
		if(depth==3) {
			for(int i=0;i<3;++i) {
				arr[nodeList[i].x][nodeList[i].y] = 1;
			}
			check = new boolean[N][M];
			map = new int[N][M];
			for(int i=0;i<virus.size();++i) {
				int tempx = virus.get(i).x;
				int tempy = virus.get(i).y;
				bfs(tempx,tempy);
			}
			int sum = 0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(map[i][j]!=2&&arr[i][j]!=1) {
						sum++;
					}
					
				}
			}
			if(sum>result)result = sum;
			for(int i=0;i<3;++i) {
				arr[nodeList[i].x][nodeList[i].y] = 0;
			}
			
			return;
		}
		
		
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(i*10+j<=index)continue;
				if(arr[i][j]==0&&!wallCheck[i][j]) {
					wallCheck[i][j] = true;
					nodeList[depth] = new Node(i,j);
					madeWall(depth+1,i*10+j);
					wallCheck[i][j] = false;
				}
			}
			
		}
		
	}
	private static void bfs(int x,int y) {

		Queue<Node> que = new LinkedList<Node>();
		check[x][y] = true;
		map[x][y] = 2;
		que.offer(new Node(x,y));
		while(!que.isEmpty()) {
			
			Node current = que.poll();
			for(int i=0;i<4;++i) {
				int nx = current.x+dx[i];
				int ny = current.y+dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if((!check[nx][ny])&&arr[nx][ny]==0) {
					que.add(new Node(nx,ny));
					check[nx][ny] = true;
					map[nx][ny] = 2;
				}
			}
			
		}
		
	}

}
