package com.ssafy.graph;

import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4 
2 4
3 5
4 5
5 6
*/

public class AdjMatrixTest {

	static boolean[][] adjMatrix;
	static int N,C;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		C = sc.nextInt(); // 간선수
		visited = new boolean[N];
		adjMatrix = new boolean[N][N];
		for(int i=0;i<C;++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		dfs(0);
		
	}
	
	private static void dfs(int current) {

		
		visited[current] = true;
		System.out.println((char)(current+'A'));
		
		for(int i=0;i<N;++i) {
			if(adjMatrix[current][i]&& !visited[i]) {
				dfs(i);
			}
		}
		
	}

}
