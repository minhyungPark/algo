package com.ssafy.subset;

import java.util.Scanner;

public class SubSetTest4 {
	
	static int[] numbers;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		int caseCount = 1<<N;	// 부분집합의 개수
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		generateSubset(caseCount);
	}
	private static void generateSubset(int caseCount) {
		for(int flag=0;flag<caseCount;++flag) {
			//flag : 0 ==> 000, 1==>001,2==>010,3==>011,......
			for(int i=0;i<N;++i) {
				System.out.print(((flag& 1<<i)!=0? numbers[i]:"X")+"\t");
			}
			System.out.println();
		}
	}
}
