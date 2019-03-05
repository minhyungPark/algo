import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1194_달이차오른다 {
	
	static int N,M;
	static char[][] map;
	static int[] start;
	static int[] exit;
	static boolean[] key;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] cnt;
	static boolean[][][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[N][M];
		cnt = new int[N*10+M];
		for(int i=0;i<N;++i) {
			map[i] = sc.next().toCharArray();
		}
		start = new int[2];
		exit = new int[2];
		key = new boolean[6];
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]=='0') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		int result = bfs(start[0],start[1]);
		System.out.println(result);
	}
	private static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t = {x,y,0,0,0,0,0,0,0,0};
//		System.out.println(t.length);
		que.offer(t);
		visited = new boolean[N*M][N][M];
		visited[0][x][y] = true;
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(!visited[c[9]][nx][ny]) {
					if(map[nx][ny]=='.'||map[nx][ny]=='0') {
						int[] temp = {nx,ny,c[2]+1,c[3],c[4],c[5],c[6],c[7],c[8],c[9]};
						que.offer(temp);
						visited[c[9]][nx][ny] = true;
					}else if(map[nx][ny]=='a'||map[nx][ny]=='b'||map[nx][ny]=='c'||
							map[nx][ny]=='d'||map[nx][ny]=='e'||map[nx][ny]=='f') {
						key[(map[nx][ny]-'a')] = true;
						c[(map[nx][ny]-'a')+3]++;
						int[] temp = {nx,ny,c[2]+1,c[3],c[4],c[5],c[6],c[7],c[8],c[9]+1};
						que.offer(temp);
						c[(map[nx][ny]-'a')+3]--;
						map[nx][ny] = '.';
						visited[c[9]][nx][ny] = true;
					}else if(map[nx][ny]=='A'||map[nx][ny]=='B'||map[nx][ny]=='C'||
							map[nx][ny]=='D'||map[nx][ny]=='E'||map[nx][ny]=='F') {
						if(c[(map[nx][ny]-'A')+3]==0)continue;
						int[] temp = {nx,ny,c[2]+1,c[3],c[4],c[5],c[6],c[7],c[8],c[9]};
						que.offer(temp);
						visited[c[9]][nx][ny] = true;
					}else if(map[nx][ny]=='1') {
						return c[2]+1;
					}
				}
			}
		}
		return -1;
	}

}
