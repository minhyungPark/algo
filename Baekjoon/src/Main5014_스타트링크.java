import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main5014_스타트링크 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();
		int res = bfs(F,S,G,U,D);
		System.out.println(res==-1?"use the stairs":res);
	}

	private static int bfs(int f, int s, int g, int u, int d) {
		Queue<int[]> que = new LinkedList<>();
		boolean[] visited = new boolean[f+1];
		visited[s] = true;
		int[] temp = {s,0};
		que.offer(temp);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			if(c[0]==g)return c[1];
			if(u!=0&&c[0]+u<=f&&!visited[c[0]+u]) {
				visited[c[0]+u]=true;
				int[] t = {c[0]+u,c[1]+1};
				que.offer(t);
			}
			if(d!=0&&c[0]-d>=1&&!visited[c[0]-d]) {
				visited[c[0]-d]=true;
				int[] t = {c[0]-d,c[1]+1};
				que.offer(t);
			}
		}
		return -1;
	}

}
