import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		visited[start] = true;
		numbers[0] = start;
		dfs(1,start);
		
		visited = new boolean[N+1];
		visited[start] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		int cnt=1;
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i=0;i<adjList[num].size();++i) {
				int temp= adjList[num].get(i);
				if(!visited[temp]) {
					visited[temp] = true;
					numbers[cnt++] =temp; 
					q.offer(temp);
				}
			}
		}
		for(int i=0;i<N;++i) {
			sb.append(numbers[i]).append(" ");
		}
		sb.append("\n");
		System.out.print(sb.toString().trim());
	}
	private static void dfs(int depth, int index) {
		if(depth==N) {
			for(int i=0;i<N;++i) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<adjList[index].size();++i) {
			int temp= adjList[index].get(i);
			if(!visited[temp]) {
				visited[temp] = true;
				numbers[depth] =temp; 
				dfs(depth+1,temp);
			}
		}
		
	}

}
