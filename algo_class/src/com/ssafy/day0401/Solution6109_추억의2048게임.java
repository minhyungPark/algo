package com.ssafy.day0401;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution6109_추억의2048게임 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			String order = sc.next();
			int[][] map = new int[N][N];
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					map[i][j]=sc.nextInt();
				}
			}
			map = go(map,order);
			sb.append("#"+t+"\n");
			for (int[] is : map) {
				for (int i : is) {
					sb.append(i+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString().trim());
		sc.close();
	}

	private static int[][] go(int[][] map, String order) {
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i=0;i<N;++i) {
			list[i]=new ArrayList<Integer>();
		}
		if(order.equals("up")) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<N;++i) {
					if(map[i][j]!=0) {
						list[j].add(map[i][j]);
					}
				}
			}
		}else if(order.equals("down")) {
			for(int j=0;j<N;++j) {
				for(int i=N-1;i>=0;--i) {
					if(map[i][j]!=0) {
						list[j].add(map[i][j]);
					}
				}
			}
		}else if(order.equals("left")) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(map[i][j]!=0) {
						list[i].add(map[i][j]);
					}
				}
			}
		}else if(order.equals("right")) {
			for(int i=0;i<N;++i) {
				for(int j=N-1;j>=0;--j) {
					if(map[i][j]!=0) {
						list[i].add(map[i][j]);
					}
				}
			}
		}
		for(int i=0;i<N;++i) {
			ArrayList<Integer> tList = new ArrayList<>();
			for(int j=0;j<list[i].size();) {
				if(j==list[i].size()-1) {
					tList.add(list[i].get(j));
					break;
				}
				int a = list[i].get(j);
				int b = list[i].get(j+1);
				if(a==b) {
					tList.add(list[i].get(j)*2);
					j+=2;
				}else {
					tList.add(list[i].get(j));
					j++;
				}
			}
			list[i].clear();
			list[i].addAll(tList);
		}
		int[][] temp = new int[N][N];
		if(order.equals("up")) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<list[j].size();++i) {
					temp[i][j]=list[j].get(i);
				}
			}
		}else if(order.equals("down")) {
			for(int j=0;j<N;++j) {
				for(int i=0;i<list[j].size();++i) {
					temp[N-i-1][j]=list[j].get(i);
				}
			}
		}else if(order.equals("left")) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<list[i].size();++j) {
					temp[i][j]=list[i].get(j);
				}
			}
		}else if(order.equals("right")) {
			for(int i=0;i<N;++i) {
				for(int j=0;j<list[i].size();++j) {
					temp[i][N-j-1]=list[i].get(j);
				}
			}
		}
		return temp;
	}
}
