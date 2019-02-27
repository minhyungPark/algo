import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2_2 {

	private static class Node{
		int x,y,cnt;

		public Node(int i, int j,int cnt) {
			super();
			this.x = i;
			this.y = j;
			this.cnt = cnt;
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N,M;
	static boolean[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		int[][] result = new int[N][M];
		for(int i=0;i<N;++i) {
			char[] temp =bf.readLine().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='1') {
					arr[i][j] = true;
					visited[i][j] = true;
				}
				
			}
		}
		int ans = -1;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				
				if(arr[i][j]) {
					arr[i][j] = false;
					Queue<Node> que = new LinkedList<Node>();
					que.offer(new Node(0,0,0));
					while(!que.isEmpty()) {
						Node current = que.poll();
						if(current.x==N-1&&current.y==M-1) {
							System.out.println(current.cnt);
						}
						visited[current.x][current.y] = true;
//			if(result[current.x][current.y]==0||result[current.x][current.y]<current.cnt)result[current.x][current.y] = current.cnt;
						for(int k=0;k<4;++k) {
							int nextX = current.x + dx[k];
							int nextY = current.y + dy[k];
							if(nextX<0||nextY<0||nextX>=N||nextY>=M) {
								continue;
							}
							if(!visited[nextX][nextY]) {
								que.offer(new Node(nextX,nextY,current.cnt+1));
							}
						}
					}
			}
				
			}
		}
		
		System.out.println();
		
	}

}
