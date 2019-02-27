package com.ssafy.floyd;

import java.util.Scanner;

public class Floyd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int[][] adjMatrix = new int[N][N];
			
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					adjMatrix[i][j] = sc.nextInt();
					if(i!=j && adjMatrix[i][j]==0)adjMatrix[i][j] = 999999;
				}
			}
			
			for(int k=0;k<N;++k) {
				for(int i=0;i<N;++i) {
					if(i==k)continue;
					for(int j=0;j<N;++j) {
						if(j==k||j==i)continue;
						if(adjMatrix[i][j]>adjMatrix[i][k]+adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
						}
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int[] is : adjMatrix) {
				int sum = 0;
				for (int is2 : is) {
					sum+=is2;
				}
				if(min>sum) min = sum;
			}
			System.out.println("#"+t+" "+min);
		}

	}

}
