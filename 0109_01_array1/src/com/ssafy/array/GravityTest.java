package com.ssafy.array;

import java.util.Scanner;

public class GravityTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;++i) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i=0; i<N; ++i) {
			int cnt = N-(i+1);
			if(arr[i]==0) continue;
			for(int j=i=1;j<N;++j) {
				if(arr[i]<=arr[j])--cnt;
			}
			if(max<cnt) max = cnt;			
		}
		System.out.println(max);
	}
}
