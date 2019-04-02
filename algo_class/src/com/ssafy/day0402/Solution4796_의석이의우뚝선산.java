package com.ssafy.day0402;

import java.util.Scanner;

public class Solution4796_의석이의우뚝선산 {

	static int N;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			num = new int[N];
			for(int i=0;i<N;++i) {
				num[i]=sc.nextInt();
			}
			int result= 0;
			for(int i=0;i<N-2;++i) {
				int tt = 0;
				if(num[i]>num[i+1])continue;
				int key = 0;
				for(int j=i;j<N;++j) {
					if(tt<num[j]) {
						tt=num[j];
						key = j;
					}else {
						break;
					}
				}
				if(key==N-1)continue;
				tt = num[key];
				int cnt = 0;
				for(int j=key+1;j<N;++j) {
					if(tt>num[j]) {
						tt=num[j];
						cnt++;
					}else break;
				}
				result+= cnt;
			}
			System.out.println("#"+t+" "+result);
		}

	}
}
