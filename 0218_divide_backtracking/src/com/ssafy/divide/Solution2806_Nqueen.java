package com.ssafy.divide;

import java.util.Scanner;

public class Solution2806_Nqueen {

	static int N;
	static int result;
	static boolean[][] checked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			result=0;
			for(int i=0;i<N;++i) {
				checked = new boolean[N][N];
				check(0,i);
				nQueen(0,i,1);
			}
			System.out.println("#"+t+" "+result);
		}
		sc.close();

	}
	private static void nQueen(int x,int y,int index) {
		if(index==N) {
			++result;
			return;
		}
		
		int nextY;
		for(int i=0;i<N;++i) {
			nextY=i;
			if(!checked[x+1][nextY]) {
				boolean[][] temp = new boolean[N][N];
				for(int j=0;j<N;++j) {
					for(int k=0;k<N;++k) {
						temp[j][k] = checked[j][k];
					}
				}
				check(x+1,nextY);
				nQueen(x+1,nextY,index+1);
				checked = temp;
			}
		}
		
	}
	private static void check(int x,int y) {
		for(int i=0;i<N;++i) {
			checked[i][y] = true;
		}
		int nextX;
		int nextY;
		nextX = x+1;
		nextY = y-1;
		while(nextX<N&&nextY>=0) {
			checked[nextX++][nextY--] = true;
		}
		nextX = x+1;
		nextY = y+1;
		while(nextX<N&&nextY<N) {
			checked[nextX++][nextY++] = true;
		}
	}
}
