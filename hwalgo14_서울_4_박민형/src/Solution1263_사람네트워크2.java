import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1263_사람네트워크2 {
	
	private static class Node implements Comparable<Node>{
		int vertex,distance;

		public Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];

			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int min = Integer.MAX_VALUE;
			boolean[] visited = null;
			int[] distance = null;
			for(int n=0;n<N;++n) {
				visited = new boolean[N];
				distance = new int[N];
				for(int i=0;i<N;++i) {
					distance[i] = 99999;
				}
				PriorityQueue<Node> q = new PriorityQueue<Node>();
				distance[n] = 0;
				q.offer(new Node(n,0));
				while(!q.isEmpty()) {
					Node temp = q.poll();
					
					if(visited[temp.vertex])continue;
					visited[temp.vertex] = true;
					
					for(int i=0;i<N;++i) {
						if(!visited[i]&&arr[temp.vertex][i]!=0&&distance[i]>distance[temp.vertex]+1) {
							distance[i] = distance[temp.vertex]+1;
							q.offer(new Node(i,distance[temp.vertex]+1));
						}
					}
				}
				int sum=0;
				for(int j=0;j<N;++j) {
					sum+=distance[j];
				}
				if(sum<min)min=sum;
			}
			System.out.println("#"+t+" "+min);
		}
	}

}
