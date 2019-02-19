package com.ssafy.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FriendRealationship2 {

	private static class Node{
		int data;
		Node next;
		
		public Node(int data,Node next) {
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		list = new Node[N];
		visited = new boolean[N];
		int[] count = new int[N];
		
		for(int i=0;i<C;++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from] = new Node(to,list[from]);
			list[to] = new Node(from,list[to]);
		}
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(0);
		visited[0] = true;
		int cnt=0;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				int current = que.poll();
				Node temp = list[current];
				while(temp!=null) {
					if(!visited[temp.data]) {
						visited[temp.data]=true;
						que.offer(temp.data);
						count[temp.data]=cnt+1;
					}
					temp = temp.next;
				}
			}
			cnt++;
		}
		System.out.println(Arrays.toString(count));
		int max=0;
		for(int i=0;i<N;++i) {
			if(count[i]>max) {
				max=count[i];
			}
		}
		for(int i=0;i<N;++i) {
			if(max==count[i])
				System.out.println((char)(i+'A'));
		}
	}

}
