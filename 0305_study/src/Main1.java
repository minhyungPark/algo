import java.util.Scanner;

public class Main1 {
	
	
	
	static int N,K;
	static int[][] map;
					//우,하,좌,상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static char[] order;
	static boolean[][] check;
	private static class Order{
		int sec;
		char dir;
		public Order(int sec, char dir) {
			this.sec = sec;
			this.dir = dir;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+1][N+1];
		for(int i=0;i<K;++i) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
		int oLen = sc.nextInt();
		Order[] oList = new Order[oLen];
		for(int i=0;i<oList.length;++i) {
			int temp = sc.nextInt();
			String s = sc.next();
			oList[i] = new Order(temp, s.charAt(0));
		}
		int dirI = 0;
		int second = 0;
		int x=1;
		int y=1;
		int len = 1;
		int index = 0;
		int[] tail = {1,1};
		check = new boolean[N+1][N+1];
		check[x][y] = true;
		int[][] dirArr = new int[N+1][N+1];
		dirArr[x][y]=dirI+1;
		while(true) {
			int nx = x+dx[dirI];
			int ny = y+dy[dirI];
			if(index<oLen) {
				if(oList[index].sec==second+1) {
					if(oList[index].dir=='D') {
						dirI = (++dirI)%4;
					}else {
						if(--dirI<0)dirI=3;
					}
					index++;
					dirArr[x][y] = dirI+1;
				}
			}
			if(nx<=0||ny<=0||nx>N||ny>N||check[nx][ny]==true) {
				second++;
				break;
			}
			if(map[nx][ny]==1) {
				check[nx][ny] = true;
				dirArr[nx][ny] = dirI+1;
				x=nx;
				y=ny;
				len++;
			}else {
//				visited = new boolean[N+1][N+1];
//				int[] pos = dfs(nx,ny,x,y,len,0);
				check[tail[0]][tail[1]]=false;
				dirArr[nx][ny] = dirI+1;
				int tempX = tail[0]+dx[dirArr[tail[0]][tail[1]]-1];
				int tempy = tail[1]+dy[dirArr[tail[0]][tail[1]]-1];
				tail[0] = tempX;
				tail[1] = tempy;
				check[nx][ny] = true;
				x=nx;
				y=ny;
//				if(pos!=null)
//					check[pos[0]][pos[1]]=false;
			}
			
			second++;
			for (boolean[] f : check) {
				for (boolean ff : f) {
					System.out.print(ff+"\t");
				}
				System.out.println();
			}
			System.out.println("===================");
//			second++;
		}
		
		
		System.out.println(second);
		
		
	}
	static boolean[][] visited;
	private static int[] dfs(int x, int y,int px,int py, int len,int depth) {
		int[] r = null;
		if(depth==len) {
			int[] temp = {px,py};
			return temp;
		}
		
		for(int i=0;i<4;++i) {
			int nx = x +dx[i];
			int ny = y+dy[i];
			if(nx<=0||ny<=0||nx>N||ny>N)continue;
			if(!visited[nx][ny]&&check[nx][ny]) {
				visited[nx][ny] = true;
				r =dfs(nx,ny,x,y,len,depth+1);
				visited[nx][ny] = false;
			}
		}
		return r;
	}

}
