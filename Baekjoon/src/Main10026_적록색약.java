import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main10026_적록색약 {

	static int N;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	static boolean[][] checked;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		checked = new boolean[N][N];
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<N;++j) {
				if(temp[j]=='R') {
					map[i][j]= 0;
				}else if(temp[j]=='G') {
					map[i][j]=1;
				}else if(temp[j]=='B') {
					map[i][j]=2;
				}
			}
		}
		int a = 0;
		int b = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(!visited[i][j]) {
					a++;
					bfs1(i,j);
				}
				if(!checked[i][j]) {
					b++;
					bfs2(i,j);
				}
			}
		}
		System.out.println(a+" "+b);
		
		
	}
	private static void bfs2(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		checked[x][y] = true;
		int[] t = {x,y,map[x][y]};
		que.offer(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx=c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(checked[nx][ny])continue;
				if((c[2]<2&&map[nx][ny]<2)||((c[2]==2)&&map[nx][ny]==2)) {
					checked[nx][ny]=true;
					int[] temp = {nx,ny,c[2]};
					que.offer(temp);
				}
			}
		}
	}
	
	
	private static void bfs1(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		visited[x][y] = true;
		int[] t = {x,y,map[x][y]};
		que.offer(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx=c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=N)continue;
				if(visited[nx][ny])continue;
				if(c[2]!=map[nx][ny])continue;
				visited[nx][ny]=true;
				int[] temp = {nx,ny,c[2]};
				que.offer(temp);
			}
		}
	}

}
