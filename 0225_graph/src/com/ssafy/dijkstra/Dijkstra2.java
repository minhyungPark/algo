package com.ssafy.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra2 {

	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int start = 0;
		int end = N-1;
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] distance = new int[N];		// 출발정점으로부터 각 정점까지의 최소비용
		
		StringTokenizer st = null;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;++j) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(distance, INF);
		distance[start]=0;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.offer(new Node(start,0));	// 출발점에 큐에 넣고 시작
		
		Node current = null;
		while(!queue.isEmpty()) {
			// a 단계: 방문하지 않은 정점들 중 출발점으로부터의 최소비용 정점을 경유지로 선택

			current = queue.poll();
			if(visited[current.vertex])continue;
			
			visited[current.vertex]=true;
			if(current.vertex == end) break;
			
			// b: current를 경유지 처리하여 start~~~~~current-미방문인접정점
			
			for(int j=0;j<N;++j) {
				if(!visited[j] && adjMatrix[current.vertex][j]!=0 && adjMatrix[current.vertex][j]+distance[current.vertex]<distance[j]) {
					distance[j] = adjMatrix[current.vertex][j]+current.distance;
					queue.offer(new Node(j,distance[j]));
				}
			}
		}
		System.out.println(distance[end]);
		
	}
	
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

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", distance=" + distance + "]";
		}
	}

}
