import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2 {

	private static class Node{
		int x,y,cnt;
		boolean breakWall;
		public Node(int i, int j,int cnt,boolean breakWall) {
			super();
			this.x = i;
			this.y = j;
			this.cnt = cnt;
			this.breakWall = breakWall;
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[][] visited = new int[N][M];
		for(int i=0;i<N;++i) {
			char[] temp =bf.readLine().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='1') {
					arr[i][j] = 1;
					visited[i][j] = 1;
				}
				
			}
		}
		Queue<Node> que = new LinkedList<Node>();
		que.offer(new Node(0,0,1,false));
		int ans=-1;
		while(!que.isEmpty()) {
			Node current = que.poll();
			if(current.x==N-1&&current.y==M-1) {
				if(ans==-1||ans>current.cnt) {
					ans = current.cnt;
				}
			}
			if(ans!=-1&&current.cnt>=ans)continue;
			if(current.breakWall)visited[current.x][current.y] = 2;
			else visited[current.x][current.y] = 3;
			for(int i=0;i<4;++i) {
				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];
				if(nextX<0||nextY<0||nextX>=N||nextY>=M) {
					continue;
				}
				if(!current.breakWall) {
					if(visited[nextX][nextY]!=3&&arr[nextX][nextY]!=1) {
						que.offer(new Node(nextX,nextY,current.cnt+1,false));
					}else if(visited[nextX][nextY]!=3&&arr[nextX][nextY]==1) {
						que.offer(new Node(nextX,nextY,current.cnt+1,true));
					}
				}else {
					if(visited[nextX][nextY]!=3&&visited[nextX][nextY]!=2&&arr[nextX][nextY]!=1) {
						que.offer(new Node(nextX,nextY,current.cnt+1,true));
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
