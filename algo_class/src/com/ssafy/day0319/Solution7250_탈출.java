package com.ssafy.day0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7250_탈출 {

	static int N,M,K;
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st = null;
		for(int t=1;t<=T;++t) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			for(int i=0;i<N;++i) {
				map[i] = bf.readLine().toCharArray();
			}
			ArrayList<int[]> fireList = new ArrayList<>();
			int[] start= new int[5];
			int[] exit= new int[3];
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(map[i][j]=='S') {
						start[0] = i;
						start[1] = j;
						start[2] = 1;
						start[3] = -1;
						start[4] = 0;
					}else if(map[i][j]=='F') {
						int[] temp = {i,j,2};
						fireList.add(temp);
					}else if(map[i][j]=='V') {
//						map[i][j]='A';
						int[] temp = {i,j,3};
						fireList.add(temp);
					}else if(map[i][j]=='E') {
						exit[0] = i;
						exit[1] = j;
					}
				}
			}
			
			int result = bfs(fireList,start,exit);
			System.out.println("#"+t+" "+result);
		}
		
	}
	private static int bfs(ArrayList<int[]> list, int[] start,int[] exit) {
		boolean[][][] visited = new boolean[3][N][M];
		Queue<int[]> que = new LinkedList<>();
		for(int i=0;i<list.size();++i) {
			int[] c = list.get(i);
			visited[0][c[0]][c[1]] = true;
			que.add(c);
		}
		visited[0][start[0]][start[1]] = true;
		que.add(start);
		while(!que.isEmpty()) {
			int[] c= que.poll();
			for(int i=0;i<4;++i) {
				int nx = c[0]+dx[i];
				int ny = c[1]+dy[i];
				if(nx<0||ny<0||nx>=N||ny>=M)continue;
				if(visited[c[2]-1][nx][ny])continue;
				switch (c[2]) {
				case 1:
					int k = c[3];
					if(visited[1][nx][ny])continue;
					if(map[nx][ny]=='W') {
						if(k==0)continue;
						if(k==-1) {
							int[] temp = {nx,ny,1,K-1,c[4]+1};
							que.add(temp);
						}else {
							int[] temp = {nx,ny,1,k-1,c[4]+1};
							que.add(temp);
						}
					}else if(map[nx][ny]=='A') {
						int tt = k;
						if(k>=0) {
							tt= k-1;
						}
						int[] temp = {nx,ny,1,-1,c[4]+1};
						visited[c[2]-1][nx][ny] = true;
						que.add(temp);
					}else if(map[nx][ny]=='E') {
						return c[4]+1;
					}
					
					break;
				case 2:
					if(map[nx][ny]=='A'||map[nx][ny]=='F') {
						int[] temp = {nx,ny,2};
						visited[c[2]-1][nx][ny] = true;
						que.add(temp);
					}
					break;
				case 3:
					if(map[nx][ny]=='A'||map[nx][ny]=='F') {
						int[] temp = {nx,ny,2};
						visited[c[2]-1][nx][ny] = true;
						que.add(temp);
					}
					if(map[nx][ny]=='E')return -1;
					break;
				}
			}
		}
		return -1;
	}
	
}
