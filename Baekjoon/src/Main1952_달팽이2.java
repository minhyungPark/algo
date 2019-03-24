import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1952_달팽이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] checked = new boolean[N][M];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int result = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t = {0,0,0};
		checked[0][0] = true;
		while(!que.isEmpty()) {
			
			int[] c = que.poll();
			if(c[2]>result)result=c[2];
			int nx = c[0]+dx[c[2]];
			int ny = c[1]+dy[c[2]];
			if(nx<0||ny<0||nx>=N||ny>=M) {
				int[] temp = {c[0],c[1],(c[2]+1)%4};
				que.add(temp);
				continue;
			}
			
			
			
		}

	}

}
