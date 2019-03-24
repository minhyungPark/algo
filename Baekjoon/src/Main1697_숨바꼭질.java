import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1697_숨바꼭질 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int result = bfs(N,K);
		System.out.println(result);
	}

	private static int bfs(int n, int k) {
		boolean[] visited = new boolean[100001];
		Queue<int[]> que = new LinkedList<int[]>();
		int[] t= {n,0};
		que.offer(t);
		while(!que.isEmpty()) {
			int[] c= que.poll();
			if(c[0]==k) {
				System.out.println(que.size());
				return c[1];
			}
			if(c[0]-1>=0&&!visited[c[0]-1]) {
				visited[c[0]-1]=true;
				int[] temp = {c[0]-1,c[1]+1};
				que.offer(temp);
			}
			if(c[0]!=0&&2*c[0]<=100000&&!visited[2*c[0]]) {
				visited[2*c[0]]=true;
				int[] temp = {2*c[0],c[1]+1};
				que.offer(temp);
			}
			if(c[0]+1<=100000&&!visited[c[0]+1]) {
				visited[c[0]+1]=true;
				int[] temp = {c[0]+1,c[1]+1};
				que.offer(temp);
			}
		}
		return 0;
	}

}
