package com.ssafy.subset;

import java.util.Scanner;

public class SubSetSumTest2 {
	static int[] numbers;
	static int N;
	static int TARGET_SUM;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		TARGET_SUM = sc.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; ++i) {
			numbers[i] = sc.nextInt();
		}
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
		// 선택
		generateSubset(index + 1, total + numbers[index],result+numbers[index]+" ");
		// 비선택
		generateSubset(index + 1, total,result);
	}
}
