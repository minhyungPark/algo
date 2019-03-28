import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main12761_돌다리 {

	static int A,B,N,M;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		int res = bfs(N,M);
		System.out.println(res);
	}
	private static int bfs(int n, int m) {
		boolean[] visited = new boolean[100001];
		Queue<int[]> que = new LinkedList<>();
		visited[n] =true;
		int[] t = {n,0};
		que.offer(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			if(c[0]==m) {
				return c[1];
			}
			
			if(c[0]+1<100000&&!visited[c[0]+1]) {
				visited[c[0]+1]=true;
				int[] temp = {c[0]+1,c[1]+1};
				que.offer(temp);
			}
			if(c[0]-1>0&&!visited[c[0]-1]) {
				visited[c[0]-1]=true;
				int[] temp = {c[0]-1,c[1]+1};
				que.offer(temp);
			}
			if(c[0]+A<=100000&&!visited[c[0]+A]) {
				visited[c[0]+A] =true;
				int[] temp = {c[0]+A,c[1]+1};
				que.offer(temp);
			}
			if(c[0]+B<=100000&&!visited[c[0]+B]) {
				visited[c[0]+B] =true;
				int[] temp = {c[0]+B,c[1]+1};
				que.offer(temp);
			}
			if(c[0]-A>0&&!visited[c[0]-A]) {
				visited[c[0]-A] =true;
				int[] temp = {c[0]-A,c[1]+1};
				que.offer(temp);
			}
			if(c[0]-B>0&&!visited[c[0]-B]) {
				visited[c[0]-B] =true;
				int[] temp = {c[0]-B,c[1]+1};
				que.offer(temp);
			}
			if(c[0]!=0&&c[0]*A<=100000&&!visited[c[0]*A]) {
				visited[c[0]*A] =true;
				int[] temp = {c[0]*A,c[1]+1};
				que.offer(temp);
			}
			if(c[0]!=0&&c[0]*B<=100000&&!visited[c[0]*B]) {
				visited[c[0]*B] =true;
				int[] temp = {c[0]*B,c[1]+1};
				que.offer(temp);
			}
			
			
		}
		
		
		
		return 0;
	}

}
