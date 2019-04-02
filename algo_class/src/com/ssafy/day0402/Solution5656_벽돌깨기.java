package com.ssafy.day0402;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution5656_벽돌깨기 {

	static int N,W,H;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] num;
	static int result;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			for(int i=0;i<H;++i) {
				for(int j=0;j<W;++j) {
					map[i][j]=sc.nextInt();
				}
			}
			result = Integer.MAX_VALUE;
			num = new int[N];
			dfs(0);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
	private static void dfs(int index) {
		if(index==N) {
			int[][] temp = new int[H][W];
			clone(temp,map);
			for(int i=0;i<N;++i) {
				go(temp,num[i]);
				for(int j=0;j<W;++j) {
					ArrayList<Integer> list = new ArrayList<>();
					for(int k=0;k<H;++k) {
						if(temp[k][j]!=0)list.add(temp[k][j]);
					}
					int a = 0;
					for(int k=0;k<H;++k) {
						if(k<H-list.size())temp[k][j]=0;
						else temp[k][j] = list.get(a++);
					}
				}
			}
			int cnt =0;
			for(int i=0;i<H;++i) {
				for(int j=0;j<W;++j) {
					if(temp[i][j]!=0)cnt++;
				}
			}
			result=result>cnt?cnt:result;
			return;
		}
		if(result==0)return;
		for(int i=0;i<W;++i) {
			num[index]=i;
			dfs(index+1);
		}
	}
	private static void go(int[][] arr, int goo) {
		int key = -1;
		for(int i=0;i<H;++i) {
			if(arr[i][goo]!=0) {
				key = i;
				break;
			}
		}
		if(key==-1)return;
		boolean[][] visited = new boolean[H][W];
		visited[key][goo] = true;
		int[] t = {key,goo,arr[key][goo]};
		Queue<int[]> que = new LinkedList<>();
		que.add(t);
		while(!que.isEmpty()) {
			int[] c = que.poll();
			int x = c[0];
			int y = c[1];
			int n = c[2];
			arr[x][y]=0;
			for(int d=0;d<4;++d) {
				for(int i=1;i<n;++i) {
					int nx = x+i*dx[d];
					int ny = y+i*dy[d];
					if(nx<0||ny<0||nx>=H||ny>=W)break;
					if(visited[nx][ny])continue;
					if(arr[nx][ny]==0)continue;
					visited[nx][ny]=true;
					int[] temp = {nx,ny,arr[nx][ny]};
					que.add(temp);
				}
			}
		}
	}
	private static void clone(int[][] target, int[][] arr) {
		for(int i=0;i<H;++i) {
			for(int j=0;j<W;++j) {
				target[i][j]=arr[i][j];
			}
		}
	}

}
