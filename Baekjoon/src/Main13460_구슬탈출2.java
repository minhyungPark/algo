import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main13460_구슬탈출2 {

	static int N,M;
	static int[][] arr;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		int[] red = new int[2];
		int[] blue = new int[2];
		int[] out = new int[2];
		for(int i=0;i<N;++i) {
			char[] temp = sc.next().toCharArray();
			for(int j=0;j<M;++j) {
				if(temp[j]=='#')arr[i][j]=-1;
				else if(temp[j]=='R') {
					red[0]=i;
					red[1]=j;
				}else if(temp[j]=='B') {
					blue[0]=i;
					blue[1]=j;
				}else if(temp[j]=='O') {
					out[0]=i;
					out[1]=j;
				}
			}
		}// 입력 끝
		int result = bfs(red,blue,out);
		System.out.println(result);
		
	}
	private static int bfs(int[] red, int[] blue, int[] out) {
		Queue<int[]> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		visited[red[0]][red[1]]=true;
		int[] t = {red[0],red[1],0};
		que.offer(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			
		}
		
		
		
		return 0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
