package com.ssafy.day0404;

import java.util.Scanner;

public class Solution3234_준환이의양팔저울 {
	
	static int N,result;
	static int[] num;
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			num = new int[N];
			chk = new boolean[N];
			result = 0;
			for(int i=0;i<N;++i) {
				num[i]=sc.nextInt();
			}
			
			go(0,0,0);
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
	private static void go(int index, int left, int right) {
		if(index==N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;++i) {
			if(chk[i])continue;
			chk[i]=true;
			go(index+1,left+num[i],right);
			if(left>=right+num[i]) {
				go(index+1,left,right+num[i]);
			}
			chk[i]=false;
		}
	}
}
