package com.ssafy.day0404;

import java.util.Scanner;

public class Solution5672_올해의조련사 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			char[] ang = new char[N];
			for(int i=0;i<N;++i) {
				ang[i] = sc.next().charAt(0);
			}
			StringBuilder sb = new StringBuilder();
			int start = 0;
			int end = N-1;
			while(true) {
				if(ang[start]-ang[end]<0) {
					sb.append(ang[start]);
					start++;
				}else if(ang[start]-ang[end]>0) {
					sb.append(ang[end]);
					end--;
				}else {
					int temp = 1;
					while(true) {
						if(start+temp>end-temp) {
							sb.append(ang[start]);
							start++;
							break;
						}else if(ang[start+temp]-ang[end-temp]<0) {
							sb.append(ang[start]);
							start++;
							break;
						}else if(ang[start+temp]-ang[end-temp]>0) {
							sb.append(ang[end]);
							end--;
							break;
						}
						temp++;
					}
				}
				if(start>end)break;
			}
			
			System.out.println("#"+t+" "+sb.toString());
		}
		sc.close();

	}


}
