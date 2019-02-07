package com.ssafy;

import java.util.Scanner;

public class MagicSquareOdd {

	static int N;
	static int[][] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][N+1];
		arr[N][N/2+1]=1;
		magicSqure(N,N/2+1,1);
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=N;++j) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	private static void magicSqure(int x, int y,int n) {
		if(n==N*N) return;
		
		int nextX,nextY;
		nextX = x+1;
		nextY = y+1;
		if(nextX>N&&nextY>N) {
			nextX=x-1;
			nextY=y;
		}else if(nextX>N) {
			nextX=1;
		}else if(nextY>N) {
			nextY=1;
		}else if(arr[nextX][nextY]!=0) {
			nextX = x-1;
			nextY = y;
		}
		arr[nextX][nextY]=n+1;
		magicSqure(nextX, nextY, n+1);
	}

}
