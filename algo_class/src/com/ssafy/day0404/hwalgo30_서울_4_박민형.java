package com.ssafy.day0404;

import java.util.Scanner;

public class hwalgo30_서울_4_박민형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		int c = sc.nextInt();
		int[] list = new int[N];
		for(int i=0;i<N;++i) {
			list[i] = sc.nextInt();
		}
		int[] check = new int[d+1];
		check[c]++;
		int cnt = 1;
		for(int i=0;i<k;++i) {
			if(check[list[i]]++==0) cnt++;
		}
		int res = cnt;
		for(int i=0;i<N;++i) {
			if(--check[list[i]]==0)cnt--;
			if(check[list[(i+k)%N]]++==0)cnt++;
			res = res<cnt?cnt:res;
		}
		System.out.println(res);
	}
}
