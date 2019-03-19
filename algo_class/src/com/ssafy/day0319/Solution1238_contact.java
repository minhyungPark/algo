package com.ssafy.day0319;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1238_contact {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int start = sc.nextInt();
			HashSet<int[]> set = new HashSet<>();
			for(int i=0;i<N/2;++i) {
				int[] temp = new int[2];
				temp[0] = sc.nextInt();
				temp[1] = sc.nextInt();
				set.add(temp);
			}
			int[][] arr = new int[set.size()][2];
			int tt=0;
			for (int[] is : set) {
				arr[tt++] = is;
			}
			ArrayList<Integer>[] adjList = new ArrayList[101];
			for(int i=0;i<101;++i) {
				adjList[i] = new ArrayList<Integer>();
			}
			for(int i=0;i<arr.length;++i) {
				adjList[arr[i][0]].add(arr[i][1]);
			}
			int result = bfs(adjList,start);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}

	private static int bfs(ArrayList<Integer>[] list, int start) {
		boolean[] visited = new boolean[101];
		Queue<int[]> que = new LinkedList<>();
		int[] ans = {start,0};
		int[] t = {start,0};
		visited[start] = true;
		que.add(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			if(ans[1]<c[1]||(ans[1]==c[1]&&ans[0]<c[0])) {
				ans = c;
			}
			for(int i=0;i<list[c[0]].size();++i) {
				if(!visited[list[c[0]].get(i)]) {
					visited[list[c[0]].get(i)] = true;
					int[] temp = {list[c[0]].get(i),c[1]+1};
					que.add(temp);
				}
			}
			
		}
		return ans[0];
	}

}
