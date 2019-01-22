package com.ssafy.subset;

import java.util.Scanner;

public class SubSetSumTest1 {
	static boolean[] selected; //false로 자동 초기화
	static int[] numbers;
	static int N;
	static int TARGET_SUM;
	static int count =0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		TARGET_SUM = sc.nextInt();
		numbers = new int[N];
		selected = new boolean[N];
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		generateSubset(0);
		System.out.println(count);
	}
	private static void generateSubset(int index) {
		if(index==N) {
			int total = 0;
			for(int s=0;s<N;++s) {
				if(selected[s]) total += numbers[s];
			}
			if(total==TARGET_SUM)count++;
			return;
		}
		// 선택
		selected[index]=true;
		generateSubset(index+1);
		// 비선택
		selected[index]=false;
		generateSubset(index+1);
	}

}
