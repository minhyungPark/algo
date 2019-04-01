package com.ssafy.day0401;

import java.util.Scanner;

public class Solution4613_러시아국기같은깃발 {

	static int N,M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1;t<=T;++t) {
			N=sc.nextInt();
			M=sc.nextInt();
			map=new int[N][M];
			for(int i=0;i<N;++i) {
				char[] temp = sc.next().toCharArray();
				for(int j=0;j<M;++j) {
					if(temp[j]=='B')map[i][j]=1;
					else if(temp[j]=='R')map[i][j]=2;
				}
			}
			int cnt =0;
			for(int j=0;j<M;++j) {
				if(map[0][j]!=0)cnt++;
			}
			int res = dfs(1,0,cnt);
			System.out.println("#"+t+" "+res);
		}
		sc.close();
	}
	private static int dfs(int depth, int color, int cnt) {
		int res = Integer.MAX_VALUE;
		if(depth==N) {
			return cnt;
		}
		if(depth==N-1&&color==0)return res;
		if(color!=2&&depth!=N-1) {
			int sum1=0;
			int sum2=0;
			for(int j=0;j<M;++j) {
				if(map[depth][j]!=color) {
					sum1++;
				}
				if(map[depth][j]!=color+1) {
					sum2++;
				}
			}
			int temp1 = dfs(depth+1,color,cnt+sum1);
			int temp2 = dfs(depth+1,color+1,cnt+sum2);
			res=temp1<res?temp1:res;
			res=temp2<res?temp2:res;
		}else if(depth==N-1||color==2){
			int sum=0;
			for(int j=0;j<M;++j) {
				if(map[depth][j]!=2) {
					sum++;
				}
			}
			int temp = dfs(depth+1,2,cnt+sum);
			res=temp<res?temp:res;
		}
		return res;
	}

}
