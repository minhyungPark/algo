package com.ssafy.knapsack;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();			// 아이템 수
		int W = sc.nextInt();			// 제한 무게
		int[] weights = new int[N+1];	// 아이템 무게
		int[] profits = new int[N+1];	// 아이템 가치
		
		int[][] k = new int[N+1][W+1];
		
		for(int i=1;i<=N;++i) {
			profits[i] = sc.nextInt();
			weights[i] = sc.nextInt();
		}
		
		for(int i=1;i<=N;++i) {		// 모든 아이템 시도
			for(int w=1;w<=W;++w) {
				if(weights[i]<=w) {		// 현 아이템 무게가 구하고자 하는 무게보다 같거나 작다면
					k[i][w] = Math.max((k[i-1][w-weights[i]]+profits[i]), k[i-1][w]);
				}else {
					k[i][w] = k[i-1][w];
				}
			}
		}
		System.out.println(k[N][W]);
	}

}
