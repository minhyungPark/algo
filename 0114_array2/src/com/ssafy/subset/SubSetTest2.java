package com.ssafy.subset;

import java.util.Scanner;

public class SubSetTest2 {
	
	static boolean[] selected; //false로 자동 초기화
	static int[] numbers;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		selected = new boolean[N];
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		generateSubset(0);
	}
	private static void generateSubset(int index) {
		if(index==N) {
			for(int s=0;s<N;++s) {
				System.out.print((selected[s]?numbers[s]:"X")+"\t");
			}
			System.out.println();
			return;
		}
		for(int i=1;i>=0;--i) {
			selected[index] = (i==1)?true:false;
			generateSubset(index+1);
		}
		/*
		// 선택
		selected[index]=true;
		generateSubset(index+1);
		// 비선택
		selected[index]=false;
		generateSubset(index+1);*/
	}

}
