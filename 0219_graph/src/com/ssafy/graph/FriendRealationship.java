package com.ssafy.graph;

import java.util.Scanner;

public class FriendRealationship {

	private static class Node{
		int data;
		Node next;
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}

	static int N,C;
	static boolean[] visited;
	static Node[] list;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		list = new Node[N];
		for(int i=0;i<C;++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from] = new Node(to,list[from]);
			list[to] = new Node(from,list[to]);
		}
		Node temp = list[0];
		int result = Integer.MIN_VALUE;
		while(temp!=null) {
			visited = new boolean[N];
			visited[0] = true;
			count=0;
			dfs(temp.data);
			System.out.println(count);
			if(count>result) {
				result = count;
			}
			temp = temp.next;
		}
		System.out.println("결과: "+result);
	}

	private static void dfs(int current) {
		
		visited[current] = true;
		count++;
		Node temp = list[current];
		while(temp!=null) {
			if(!visited[temp.data]) {
				dfs(temp.data);
			}
			temp = temp.next;
		}
	}

}
