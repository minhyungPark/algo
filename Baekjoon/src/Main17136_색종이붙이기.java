import java.util.Scanner;

public class Main17136_색종이붙이기 {

	static int N = 10;
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[][] map = new int[N][N];
		int cnt = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==1)cnt++;
			}
		}
		result = Integer.MAX_VALUE;
		int res = simul(map);
		if(result==Integer.MAX_VALUE)result = -1;
		if(cnt==0)result =0;
		System.out.println(result);
		sc.close();
	}
	private static int simul(int[][] map) {
		int res = 0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j]==1) {
					boolean[][] visited= new boolean[N][N];
					int[] block = new int[6];
					res = dfs(i,j,block,visited,0,map,Integer.MAX_VALUE);
					break;
				}
			}
		}
		if(res==Integer.MAX_VALUE)res = -1;
		
		return res;
	}
	private static int dfs(int x, int y, int[] block, boolean[][] visited, int bCnt,int[][] map,int min) {
		int res = Integer.MAX_VALUE;
		if(isFull(map,visited)) {
			if(result>bCnt)result=bCnt;
			return bCnt;
		}
		if(bCnt>=min)return Integer.MAX_VALUE;
		for(int i=5;i>=1;--i) {
			if(block[i]>=5)continue;
			boolean flag = canPut(x,y,map,visited,i);
			if(!flag) continue;
			put(x,y,map,visited,i);
			int[] next = nextPos(map,visited);
			if(next==null) {
				if(isFull(map,visited)) {
					poll(x,y,map,visited,i);
					if(result>bCnt+1)result=bCnt+1;
					return bCnt+1;
				}
				poll(x, y, map, visited, i);
				return Integer.MAX_VALUE;
			}
			block[i]++;
			int temp = dfs(next[0], next[1], block, visited, bCnt+1, map,min);
			poll(x, y, map, visited, i);
			block[i]--;
			min=min>temp?temp:min;
			res=res>temp?temp:res;
		}
		
		return res;
	}
	private static void poll(int x, int y, int[][] map, boolean[][] visited, int size) {
		for(int i=x;i<x+size;++i) {
			for(int j=y;j<y+size;++j) {
				visited[i][j]=false;
			}
		}
	}
	private static boolean isFull(int[][] map, boolean[][] visited) {
		int cnt1=0,cnt2=0;
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j]==1)cnt1++;
			}
		}
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(visited[i][j])cnt2++;
			}
		}
		if(cnt1==cnt2)return true;
		return false;
	}
	private static int[] nextPos(int[][] map, boolean[][] visited) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j]==1&&!visited[i][j]) {
					int[] temp = {i,j};
					return temp;
				}
			}
		}
		
		return null;
	}
	private static void put(int x, int y, int[][] map, boolean[][] visited, int size) {
		for(int i=x;i<x+size;++i) {
			for(int j=y;j<y+size;++j) {
				visited[i][j] = true;
			}
		}
		
	}
	private static boolean canPut(int x, int y, int[][] map, boolean[][] visited, int size) {
		
		for(int i=x;i<x+size;++i) {
			for(int j=y;j<y+size;++j) {
				if(i>=N||j>=N||map[i][j]==0||visited[i][j])return false;
			}
		}
		
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
