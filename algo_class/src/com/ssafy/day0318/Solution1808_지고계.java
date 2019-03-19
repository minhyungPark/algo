package com.ssafy.day0318;

import java.util.Scanner;

public class Solution1808_지고계 {

	static int result;
	static boolean[] number;
	static int ans;
	static int minN;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			number = new boolean[10];
			ans = Integer.MAX_VALUE;
			for(int i=0;i<10;++i) {
				int temp = sc.nextInt();
				if(temp==1)number[i]=true;
			}
			result= sc.nextInt();
			for(int i=0;i<10;++i) {
				if(number[i]) {
					minN = i;
					break;
				}
			}
			// flag : -1 = 처음 시작, 0 : 전에 눌린 곱하기 없이 숫자만 , 
			//		 1 : 바로 전에 곱하기 클릭 	2 : 곱하기 누르고 숫자누른 상태
			dfs(0,-1,0,1);
			if(ans==Integer.MAX_VALUE)ans=-1;
			System.out.println("#"+t+" "+ans);
		}

	}
	private static void dfs(int index, int flag,int preN,int total) {

		if(preN*total==result) {
			// 결과값이 나올 수 있으므로 '=' 누른 답을 저장해준다.
			if(index+1<ans)ans = index+1;
			return;
		}
		
		
		if(total>result)return;
		if(index>=ans)return;
		
		for(int i=0;i<10;++i) {
			if(number[i]) {
				if(flag==-1) {
					if(i==0)continue;
					dfs(index+1,0,i,total);
				}else if(flag==0) {
					if(preN*10+i>result)continue;
					dfs(index+1,0,preN*10+i,total);
				}else if(flag==1) {
					if(i==0)continue;
					if(i*total>result)continue;
					dfs(index+1,2,i,total);
				}else if(flag==2) {
					if((preN*10+i)*total>result)continue;
					dfs(index+1,2,preN*10+i,total);
				}
			}
		}
		
		if((flag==2||flag==0)&&preN!=1) {
			if(preN*total<=result&&result%(preN*total)==0)dfs(index+1,1,0,total*preN);
		}
		
		
	}

}
