package com.ssafy.subset;

import java.util.Scanner;

public class SubSetSumTest3 {
	static int[] numbers;
	static int N;
	static int TARGET_SUM;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		TARGET_SUM = sc.nextInt();
		generateSubset(0, 0,"");
		System.out.println(count);
	}

	private static void generateSubset(int index, int total,String result) {
		if (index == N)	{
			if (total == TARGET_SUM) {
				count++;
				System.out.println(result);
			}
			return;
		}
		for(int i=1;i<=6;++i) {
			generateSubset(index + 1, total + i,result+i+" ");
		}
	}
}
