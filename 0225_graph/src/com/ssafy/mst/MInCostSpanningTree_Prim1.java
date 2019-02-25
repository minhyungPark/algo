package com.ssafy.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MInCostSpanningTree_Prim1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = null;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine()," ");
			for(int j=0;j<N;++j) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int minIndex, min;
		int result = 0;	// 최소비용 누적
		
		visited[0] = true;	// 임의의 0번 정점 선택
		list.add(0);		// 임의의 0번 정점 방문 리스트에 추가.
		
		for(int c=0;c<N-1;++c) {
			// 1 : 방문 정점과 해당 인접정점의 최소비용이 되는 정점 찾기
			min = Integer.MAX_VALUE;
			minIndex = 0;
			for(int i : list) {
				for(int j=0;j<N;++j) {
					if(!visited[j]&&adjMatrix[i][j]!=0&&adjMatrix[i][j]<min) {
						min = adjMatrix[i][j];
						minIndex = j;
					}
				}
			}
			visited[minIndex]=true;
			list.add(minIndex);
			result+=min;
		}
		
		System.out.println(result);
	}

}
