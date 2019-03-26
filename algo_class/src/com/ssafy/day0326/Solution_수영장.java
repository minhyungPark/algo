package com.ssafy.day0326;

import java.util.Scanner;

public class Solution_수영장 {

	static int[] price;
	static int[] month;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;++t) {
			price = new int[4];
			for(int i=0;i<4;++i) {
				price[i] = sc.nextInt();
			}
			month = new int[12];
			for(int i=0;i<12;++i) {
				month[i] = sc.nextInt();
			}
			int result = dfs(0,0);
			result = result>price[3]?price[3]:result;
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
	private static int dfs(int m, int sum) {
		int res = Integer.MAX_VALUE;
		if(m>=12) {
			return sum;
		}
		if(month[m]!=0) {
			int temp1 = dfs(m+1,sum+price[0]*month[m]);
			int temp2 = dfs(m+1,sum+price[1]);
			int temp3 = dfs(m+3,sum+price[2]);
			res = Math.min(temp1, Math.min(temp2, temp3));
		}else {
			int temp = dfs(m+1,sum);
			res = Math.min(res, temp);
		}
		
		return res;
	}

}
