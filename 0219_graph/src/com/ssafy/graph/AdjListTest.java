package com.ssafy.graph;

import java.io.FileInputStream;
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

public class AdjListTest {

	private static class Node{
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		public Node(int vertex) {
			this.vertex = vertex;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}
	
	
	static Node[] adjList;
	static int N;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int C = sc.nextInt(); // 간선수
		visited = new boolean[N];
		adjList = new Node[N];
		for(int i=0;i<C;++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		System.out.println("-----DFS-----");
		dfs(0);
		System.out.println("-----BFS-----");
		bfs();
		sc.close();
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		System.out.println((char)(current+'A'));
		Node temp = adjList[current];
		while(temp!=null) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
			temp = temp.next;
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N];
		queue.offer(0);
		visited[0] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+'A'));
			Node temp = adjList[current];
			while(temp!=null) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
				temp = temp.next;
			}
		}
	}
	
}
