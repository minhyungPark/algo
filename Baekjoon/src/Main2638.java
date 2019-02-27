import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2638 {

	private static class Node{
		int x,y;
		Node(int x,int y){
			this.x = x;
			this.y=y;
		}
	}
	private static void bfs1(int x,int y) {
		if(map[x][y]==-1)return;

		Queue<Node> que = new LinkedList<Node>();
		que.offer(new Node(x,y));
		map[x][y] = -1;
		while(!que.isEmpty()) {
			Node temp = que.poll();
			for(int i=0;i<4;++i) {
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];
				if(nextX<0||nextY<0||nextX>=N||nextY>=M)continue;
				if(map[nextX][nextY]==0) {
					map[nextX][nextY] = -1;
					que.offer(new Node(nextX,nextY));
				}
			}
		}
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs1(0, 0);
		int flag = 0;
		int result = 0;
		
		while(true) {
			flag=0;
			ArrayList<Node> list = new ArrayList<Node>();
			ArrayList<Node> list1 = new ArrayList<Node>();
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(map[i][j]==1) {
						int temp=0;
						Node[] blank = new Node[2];
						for(int k=0;k<4;++k) {
							int nx=i+dx[k];
							int ny=j+dy[k];
							if(map[nx][ny]==-1)temp++;
							else if(map[nx][ny]==0){
								if(blank[0]==null)blank[0] = new Node(nx,ny);
								else blank[1] = new Node(nx,ny);
							}
						}
						if(temp>=2) {
							list1.add(new Node(i,j));
//							map[i][j]=-1;
							int cnt=0;
							while(blank[cnt]!=null) {
								list.add(blank[cnt++]);
							}
						}
					}else ++flag;
				}
			}
			if(flag==N*M)break;
			for (Node node : list1) {
				map[node.x][node.y] = -1;
			}
			
			for (Node node : list) {
				bfs1(node.x,node.y);
			}
			result++;
		}
		System.out.println(result);
	}
}
