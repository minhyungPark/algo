package com.ssafy.dp;

import java.util.Scanner;

public class ChangeMinCoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1];
		int min;
		
		for(int i=1;i<=money;++i) {
			min = Integer.MAX_VALUE;
			// 1원시도
			if(i>=1&&D[i-1]+1<min)min = D[i-1]+1;
			// 4원시도
			if(i>=4&&D[i-4]+1<min)min = D[i-4]+1;
			// 6원시도
			if(i>=6&&D[i-6]+1<min)min = D[i-6]+1;
			D[i] = min;
		}
		System.out.println(D[money]);
	}
}