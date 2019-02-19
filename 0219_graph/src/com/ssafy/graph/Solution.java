package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

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

	static int N = 101;
	static int C;
	static boolean[] visited;
	static Node[] list;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input1.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int start=0;
			C = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			list = new Node[N];
			visited = new boolean[N];
			int[] count = new int[N];
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<C/2;++i) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from] = new Node(to,list[from]);
//				list[to] = new Node(from,list[to]);
			}
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(start);
			visited[start] = true;
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
			for(int i=N-1;i>0;--i) {
				if(max==count[i]) {
					System.out.println("#"+t+" "+i);
					break;
				}
			}
			
		}
	}

}
