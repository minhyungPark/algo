package com.ssafy.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra1 {

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
		
		int min,current;
		for(int i=0;i<N;++i) {
			min = INF;
			current = 0;
			// a 단계: 방문하지 않은 정점들 중 출발점으로부터의 최소비용 정점을 경유지로 선택
			for(int j=0;j<N;++j) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current]=true;
			if(current == end) break;
			
			// b: current를 경유지 처리하여 start~~~~~current-미방문인접정점
			
			for(int j=0;j<N;++j) {
				if(!visited[j] && adjMatrix[current][j]!=0 && adjMatrix[current][j]+distance[current]<distance[j]) {
					distance[j] = adjMatrix[current][j]+distance[current];
				}
			}
		}
		System.out.println(distance[end]);
		
	}

}
