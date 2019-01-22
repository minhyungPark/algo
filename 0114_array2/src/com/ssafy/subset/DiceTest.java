package com.ssafy.subset;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	static int N;
	static int count;
	static int TARGET_SUM;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 주사위 개수
		numbers = new int[N];
		count = 0;
		TARGET_SUM = sc.nextInt();	// 타겟 합
		
		diceSum(0,0);
		System.out.println(count);
	}

	private static void diceSum(int index,int total) {
		if(TARGET_SUM<total)return;
//		if(TARGET_SUM>total+(N-index)*6) return;
		if(index==N) {
			if(TARGET_SUM==total) {
				count++;
				for(int i=0;i<N;++i) {
					System.out.print(numbers[i]+" ");
				}
				System.out.println();
//				System.out.println(Arrays.toString(numbers));
				/*for (int n : numbers) {
					System.out.printf("%d ",n);
				}
				System.out.println();*/
			}
			return;
		}
		
		for(int i=1;i<=6;++i) {
			numbers[index] = i;
			diceSum(index+1,total+i);
		}
		
	}
}
