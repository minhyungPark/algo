import java.util.Scanner;

public class Main14499_주사위굴리기 {

	static int N,M;
	static int[][] map;
	static int[] dice;
	static int up,bottom,right,left,front,back;
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		dice = new int[2];
		dice[0] = sc.nextInt();
		dice[1] = sc.nextInt();
		int K = sc.nextInt();
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] order = new int[K];
		for(int i=0;i<K;++i) {
			order[i]=sc.nextInt();
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<K;++i) {
			boolean flag = roll(order[i]);
			if(flag) {
				sb.append(up).append("\n");
			}
			
		}
		System.out.println(sb.toString().trim());

	}
	private static boolean roll(int dir) {
		int nx = dice[0]+dx[dir];
		int ny = dice[1]+dy[dir];
		if(nx<0||ny<0||nx>=N||ny>=M)return false;
		if(dir==1) {
			int temp = bottom;
			bottom = right;
			right = up;
			up = left;
			left = temp;
			
		}else if(dir==2) {
			int temp = up;
			up = right;
			right = bottom;
			bottom = left;
			left = temp;
		}else if(dir==3) {
			int temp = up;
			up = front;
			front = bottom;
			bottom = back;
			back = temp;
		}else if(dir==4) {
			int temp = up;
			up = back;
			back = bottom;
			bottom = front;
			front = temp;
		}
		
		if(map[nx][ny]==0) {
			map[nx][ny]=bottom;
		}else {
			bottom = map[nx][ny];
			map[nx][ny] = 0;
		}
		dice[0]=nx;
		dice[1]=ny;
		return true;
	}

}
