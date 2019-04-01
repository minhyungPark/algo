package com.ssafy.day0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3074_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			long result = 0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			long[] sec = new long[N];
			long max = 0;
			for(int i=0;i<N;++i) {
				sec[i]=Long.parseLong(bf.readLine());
				if(max<sec[i])max=sec[i];
			}
			long left=0;
			long right=M*max;
			while(left<=right) {
				long sum = 0;
				long mid = (left+right)/2;
				for(int i=0;i<N;++i) {
					sum+=mid/sec[i];
				}
				if(sum>=M) {
					result =mid;
					right=mid-1;
				}else {
					left=mid+1;
				}
			}
			System.out.println("#"+t+" "+result);
		}
		
	}

}
