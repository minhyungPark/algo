package com.ssafy.subset;

import java.util.Scanner;

public class SubSetSumTest {
	
	static int[] numbers;
	static int N;
	static int TARGET_SUM = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
		N = 10;
		numbers = new int[N];
		int caseCount = 1<<N;	// 부분집합의 개수
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		System.out.print((checkSubsetSum(caseCount))? "존재":"비존재");
	}
	private static boolean checkSubsetSum(int caseCount) {
		int sum ;
		for(int flag=1;flag<caseCount;++flag) {
			sum = 0;
			//flag : 0 ==> 000, 1==>001,2==>010,3==>011,......
			for(int i=0;i<N;++i) {
				if((flag& 1<<i)!=0)	sum+=numbers[i];
			}
			if(sum==TARGET_SUM)return true;
		}
		return false;
	}
}
