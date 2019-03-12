import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main16253_나무재테크 {

	static int[] dx = {0,0,1,-1,1,-1,1,-1};
	static int[] dy = {1,-1,0,0,1,-1,-1,1};
	static int N,M,K;
	static int[][] A;
	static int[][] map;
//	static PriorityQueue<Integer>[][] treeMap;
	static PriorityQueue<int[]> treeMap;
	static ArrayList<int[]> dead;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N+1][N+1];
		map = new int[N+1][N+1];
//		treeMap = new PriorityQueue[N+1][N+1];
		treeMap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		dead = new ArrayList<int[]>();
		for(int i=1;i<=N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;++j) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		for(int m=0;m<M;++m) {
			st = new StringTokenizer(bf.readLine());
			int ta = Integer.parseInt(st.nextToken());
			int tb = Integer.parseInt(st.nextToken());
			int tage = Integer.parseInt(st.nextToken());
			int[] temp = {ta,tb,tage};
			treeMap.add(temp);
		}
		
		for(int i=0;i<K;++i) {
			spring();
			summer();
			fall();
			winter();
		}
		int result = 0;
		result += treeMap.size();
		System.out.println(result);
		
	}
	private static void spring() {
		int tsize = treeMap.size();
		ArrayList<int[]> tlist = new ArrayList<int[]>();
		for(int i=0;i<tsize;++i) {
			int[] c = treeMap.poll();
			if(c[2]<=map[c[0]][c[1]]) {
				map[c[0]][c[1]]-=c[2];
				int[] temp = {c[0],c[1],c[2]+1};
				tlist.add(temp);
			}else {
				int[] temp = {c[0],c[1],c[2]};
				dead.add(temp);
			}
		}
		treeMap.addAll(tlist);
//		for(int i=1;i<=N;++i) {
//			for(int j=1;j<=N;++j) {
//				int tsize = treeMap[i][j].size();
//				ArrayList<Integer> tlist = new ArrayList<Integer>();
//				for(int s=0;s<tsize;++s) {
//					int namu = treeMap[i][j].poll();
//					if(namu<=map[i][j]) {
//						map[i][j]-=namu;
//						tlist.add(++namu);
//					}else {
//						int[] temp= {i,j,namu};
//						dead.add(temp);
//					}
//				}
//				treeMap[i][j].addAll(tlist);
//			}
//		}
	}
	private static void summer() {
		for(int i=0;i<dead.size();++i) {
			int[] tree = dead.get(i);
			map[tree[0]][tree[1]] += tree[2]/2;
		}
		dead.clear();
	}
	private static void fall() {
		int tsize = treeMap.size();
		ArrayList<int[]> tlist = new ArrayList<int[]>();
		for(int i=0;i<tsize;++i) {
			int[] c = treeMap.poll();
			if(c[2]%5==0) {
				for(int d=0;d<8;++d) {
					int nx = c[0]+dx[d];
					int ny = c[1]+dy[d];
					if(nx<1||ny<1||nx>N||ny>N)continue;
					int[] temp = {nx,ny,1};
					tlist.add(temp);
				}
			}
			tlist.add(c);
		}
		treeMap.addAll(tlist);
		
//		for(int i=1;i<=N;++i) {
//			for(int j=1;j<=N;++j) {
//				ArrayList<Integer> tlist = new ArrayList<Integer>();
//				tlist.addAll(treeMap[i][j]);
//				for(int s=0;s<tlist.size();++s) {
//					if(tlist.get(s)%5==0) {
//						for(int a=0;a<8;++a) {
//							int nx = i+dx[a];
//							int ny = j+dy[a];
//							if(nx<1||ny<1||nx>N||ny>N)continue;
//							treeMap[nx][ny].add(1);
//						}
//					}
//				}
//				
//			}
//		}
//		
	}
	private static void winter() {
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=N;++j) {
				map[i][j] += A[i][j];
			}
		}
		
	}

}
