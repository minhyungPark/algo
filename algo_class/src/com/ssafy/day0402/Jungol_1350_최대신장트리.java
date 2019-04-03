package com.ssafy.day0402;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Jungol_1350_최대신장트리 {
	
	static int N,M;
	static int[] parents;
	private static class Node implements Comparable<Node>{
		int x,y,w;
		Node(int x,int y,int w){
			this.x=x;
			this.y=y;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return o.w-this.w;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];
		Arrays.fill(parents, -1);
		PriorityQueue<Node> que = new PriorityQueue<>();
		for(int i=0;i<M;++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			que.add(new Node(x, y, w));
		}
		int result = 0;
		for(int i=0;i<M;++i) {
			Node temp = que.poll();
			if(union(temp.x,temp.y)) {
				result+=temp.w;
			}
		}
		System.out.println(result);
		sc.close();
	}
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa!=pb) {
			parents[pb] = pa;
			return true;
		}
		return false;
	}
	private static int find(int a) {
		if(parents[a]==-1)return a;
		return parents[a] = find(parents[a]);
	}

}
