import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16956_늑대와양 {
	
	static int N,M;
	static char[][] map;
	static ArrayList<int[]> wolfList;
	static ArrayList<int[]> blockList;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0;i<N;++i) {
			map[i] = bf.readLine().toCharArray();
		}
		wolfList = new ArrayList<int[]>();
		blockList = new ArrayList<int[]>();
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]=='W') {
					int[] temp = {i,j};
					wolfList.add(temp);
				}
			}
		}
		bfs();
		for(int i=0;i<blockList.size();++i) {
			map[blockList.get(i)[0]][blockList.get(i)[1]]='D';
		}
		StringBuilder sb = new StringBuilder();
		if(bfs1()==0) {
			System.out.println(0);
		}else {
			System.out.println(1);
			for (char[] ch : map) {
				for (char c : ch) {
					sb.append(c);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString().trim());
		}
		
	}
	private static int bfs1() {
		char[][] arr = new char[N][M];
		clone(map, arr);
		Queue<int[]> que = new LinkedList<int[]>();
		for(int i=0;i<wolfList.size();++i) {
			que.offer(wolfList.get(i));
		}
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(arr[nx][ny]=='S') {
					return 0;
				}
				if(arr[nx][ny]=='.') {
					arr[nx][ny]='A';
					int[] temp = {nx,ny};
					que.offer(temp);
				}
			}
		}
		return 1;
	}
	private static void bfs() {
		char[][] arr = new char[N][M];
		clone(map, arr);
		Queue<int[]> que = new LinkedList<int[]>();
		for(int i=0;i<wolfList.size();++i) {
			que.offer(wolfList.get(i));
		}
		while(!que.isEmpty()) {
			int[] c = que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(arr[nx][ny]=='S'&&arr[c[0]][c[1]]!='W') {
					int[] temp = {c[0],c[1]};
					arr[c[0]][c[1]]='D';
					blockList.add(temp);
					continue;
				}
				if(arr[nx][ny]=='.') {
					arr[nx][ny]='A';
					int[] temp = {nx,ny};
					que.offer(temp);
				}
			}
			
		}
//		System.out.println();
		
		
		
	}
	private static void clone(char[][] arr,char[][] target) {
		
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				target[i][j] = arr[i][j];
			}
		}
	}

}
