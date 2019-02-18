package com.ssafy.backtracking;

import java.util.Scanner;

public class Solution2806_teacher {

	static int size;
	static boolean[] col,slash,bSlash;
	static int count=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			size = sc.nextInt();
			count = 0;
			
			col = new boolean[size+1];
			slash = new boolean[2*size+1];	//  / : 우상향
			bSlash = new boolean[2*size+1];	//  \ : 우하향
			go(1);
			System.out.println("#"+t+" "+count);
		}
		sc.close();
	}
	private static void go(int row) {
		if(row==size+1) {
			count++;
			return;
		}
		for(int i=1;i<=size;++i) {
			// 열, /, \ 체크
			if(!col[i]&&!slash[row+i]&&!bSlash[size+row-i]) {
				col[i] = slash[row+i] = bSlash[size+row-i] = true;
				go(row+1);
				col[i] = slash[row+i] = bSlash[size+row-i] = false;
			}
		}
		
	}
}
