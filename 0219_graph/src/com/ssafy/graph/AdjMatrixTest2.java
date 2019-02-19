
package com.ssafy.graph;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
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

public class AdjMatrixTest2 {

	static boolean[][] adjMatrix;
	static int N,C;
	static boolean[] visited;
	static int start = 3;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
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
		System.out.println("-----DFS-----");
		dfs(start);
		System.out.println("-----BFS-----");
		bfs();
		sc.close();
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
	
	private static void bfs() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N];
		queue.offer(start);
		visited[start] = true;
		System.out.println((char)(start+'A'));

		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i=0;i<N;++i) {
				if(adjMatrix[current][i]&&!visited[i]) {
					queue.offer(i);
					visited[i] = true;
					System.out.println((char)(i+'A'));
				}
			}
		}
		
	}

}

