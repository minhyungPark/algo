package com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MInCostSpanningTree_Prim2_최적화 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer st = null;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine()," ");
			for(int j=0;j<N;++j) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int minIndex, min;
		int result = 0;	// 최소비용 누적
		
		minEdge[0] = 0;
		
		for(int c=0;c<N;++c) {
			//1. 미방문 정점 중 edge min이 되는 정점 찾기
			min = Integer.MAX_VALUE;
			minIndex = 0;
			for(int i=0;i<N;++i) {
				if(!visited[i] && minEdge[i]<min) {
					min = minEdge[i];
					minIndex = i;
				}
			}
			visited[minIndex]=true;
			result+=min;
			
			//2. 선택된 정점으로 미방문 정점 minEdge 최소값 갱신
			for(int i=0;i<N;++i) {
				if(!visited[i]&&adjMatrix[minIndex][i]!=0&&adjMatrix[minIndex][i]<minEdge[i]) {
					minEdge[i]=adjMatrix[minIndex][i];
				}
			}
		}
		System.out.println(result);
	}

}
