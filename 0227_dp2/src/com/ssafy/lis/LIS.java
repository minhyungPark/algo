package com.ssafy.lis;

import java.util.Arrays;
import java.util.Scanner;

public class LIS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] LIS = new int[N+1];
		for(int i=1;i<=N;++i) {
			arr[i] = sc.nextInt();
		}
		for(int i=1;i<=N;++i) {
			LIS[i] = 1;
			for(int j=1;j<i;++j) {
				if(arr[j]<=arr[i]&&LIS[j]+1>LIS[i]) {
					LIS[i] = LIS[j]+1;
				}
			}
		}
		System.out.println(Arrays.toString(LIS));

	}

}
