import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {

	static int N,M;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int[] numbers;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		numbers = new int[N];
		for(int i=0;i<N+1;++i) {
			adjList[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int tempa = Integer.parseInt(st.nextToken());
			int tempb = Integer.parseInt(st.nextToken());
			adjList[tempa].add(tempb);
			adjList[tempb].add(tempa);
		}
		for(int i=0;i<N;++i) {
			Collections.sort(adjList[i]);
		}
		visited[start] = true;
		sb.append(start).append(" ");
		dfs(0,start);
		sb.append("\n");
		bfs(start);
		System.out.println(sb.toString().trim());
		
	}
	private static void dfs(int depth,int index) {
		
		for(int i=0;i<adjList[index].size();++i) {
			int temp = adjList[index].get(i);
			if(visited[temp])continue;
			visited[temp] =true;
			sb.append(temp).append(" ");
			dfs(depth+1,temp);
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		visited = new boolean[N+1];
		visited[start] = true;
		que.add(start);
		sb.append(start).append(" ");
		while(!que.isEmpty()) {
			int c = que.poll();
			for(int i=0;i<adjList[c].size();++i) {
				int temp = adjList[c].get(i);
				if(visited[temp])continue;
				visited[temp]=true;
				sb.append(temp).append(" ");
				que.add(temp);
			}
		}
		return;
	}
	

}
