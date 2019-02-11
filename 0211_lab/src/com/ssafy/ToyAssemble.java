package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ToyAssemble {

	static int baseToy;
	static int[][] toy;
	static boolean[] check;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		M = Integer.parseInt(bf.readLine());
		toy = new int[N+1][N+1];
		check = new boolean[N+1];
		StringTokenizer st;
		for(int i=1;i<M;++i) {
			st = new StringTokenizer(bf.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			check[X] = true;
			toy[X][Y] += K;
		}
		
		
	}

}
