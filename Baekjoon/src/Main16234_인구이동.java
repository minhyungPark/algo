import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16234_인구이동 {

	private static class Node{
		int x,y;
		Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int N,L,R;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static ArrayList<Integer>[] list;
	static boolean[][] checked; // 국경이 열려있는지
	static boolean[][] visited;	// 방문 했는지
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		int result = 0;
		list = new ArrayList[N*N];
		for(int i=0;i<N*N;++i) {
			list[i] = new ArrayList<Integer>();
		}
		while(check(map)) {
			result++;
			visited = new boolean[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(checked[i][j]&&!visited[i][j]) {
						ArrayList<Node> nList = bfs(i,j);
						int sum=0;
						int size = nList.size();
						for(int s=0;s<size;++s) {
							sum+=map[nList.get(s).x][nList.get(s).y];
						}
						for(int s=0;s<size;++s) {
							map[nList.get(s).x][nList.get(s).y] = sum/size;
						}
					}
				}
			}
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
		}
		System.out.println(result);
		sc.close();

	}
	private static ArrayList<Node> bfs(int startX, int startY) {
		ArrayList<Node> nlist = new ArrayList<Node>();
		int xy = startX*N+startY;
		visited[startX][startY] = true;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(xy);
		nlist.add(new Node(startX,startY));
		while(!que.isEmpty()) {
			int c = que.poll();
			for(int i=0;i<list[c].size();++i) {
				int t = list[c].get(i);
				int nx = t/N;
				int ny = t%N;
				if(visited[nx][ny])continue;
				visited[nx][ny]=true;
				nlist.add(new Node(nx,ny));
				que.add(t);
			}
		}
		return nlist;
	}
	private static boolean check(int[][] arr) {
		checked = new boolean[N][N];
		for(int i=0;i<N*N;++i) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				for(int d=0;d<4;++d) {
					int nx = i+dx[d];
					int ny = j+dy[d];
					if(nx<0||ny<0||nx>=N||ny>=N)continue;
					int diff = Math.abs(map[i][j]-map[nx][ny]);
					if(diff<=R&&diff>=L) {
						checked[i][j] = true;
						list[i*N+j].add(nx*N+ny);
					}
				}
			}
		}
		int cnt=0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(checked[i][j])cnt++;
			}
		}
		return cnt==0?false:true;
	}
	

}
