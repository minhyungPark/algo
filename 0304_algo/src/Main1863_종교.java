import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1863_종교 {

	static int N;
	static int result;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;++i) {
			list[i] = new ArrayList<Integer>();
		}
		int M = Integer.parseInt(st.nextToken());
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		result = 0;
		for(int i=1;i<=N;++i) {
			bfs(i);
		}
		System.out.println(result);
	}
	private static void bfs(int index) {
		if(visited[index])return;
		Queue<Integer> que = new LinkedList<Integer>();
		visited[index] = true;
		que.offer(index);
		while(!que.isEmpty()) {
			int current = que.poll();
			for(int i=0;i<list[current].size();++i) {
				if(!visited[list[current].get(i)]) {
					visited[list[current].get(i)] = true;
					que.offer(list[current].get(i));
				}
			}
		}
		result++;
	}

}
