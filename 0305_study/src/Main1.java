import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
	
	static int N,K;
	static int[][] map;
					//우,하,좌,상
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static char[] order;
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
		int[] start = {1,1};
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(start);
		int dir=0,second= 0;
		int x=1,y=1;
		boolean[][] check = new boolean[N+1][N+1];
		check[1][1] = true;
		int index = 0;
		while(true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(nx<=0||ny<=0||nx>N||ny>N||check[nx][ny]) {
				second++;
				break;
			}
			
			if(map[nx][ny]==1) {
				map[nx][ny] = 0;
				check[nx][ny] = true;
				int[] temp = {nx,ny};
				que.offer(temp);
				x=nx;
				y=ny;
				second++;
			}else {
				check[nx][ny] = true;
				int[] tail = que.poll();
				check[tail[0]][tail[1]]=false;
				int[] temp = {nx,ny};
				que.offer(temp);
				x=nx;
				y=ny;
				second++;
			}
			
			if(index<oLen) {
				if(oList[index].sec==second) {
					if(oList[index].dir=='D') {
						dir=(++dir)%4;
					}else {
						dir=(dir+3)%4;
					}
					index++;
				}
			}
		}
		System.out.println(second);
	}

}
