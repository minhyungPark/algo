package com.ssafy.subset;

import java.util.Scanner;

public class SubSetTest3 {
	
	static int[] numbers;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextInt();
		}
		generateSubset(0,0);
	}
	private static void generateSubset(int index,int flag) {
		if(index==N) {
			for(int i=0;i<N;++i) {
				System.out.print(((flag& 1<<i)!=0? numbers[i]:"X")+"\t");
			}
			System.out.println();
			return;
		}
		for(int i=1;i>=0;--i) {
		  if(i==1) generateSubset(index+1,flag|(1<<index));
		  else generateSubset(index+1,flag);
		}
		
		/*// 선택
		generateSubset(index+1,flag|1<<index);// index: 0 	000 | 001<<0 ==> 001	====> 001
											  // index: 1 	001 | 001<<1 ==> 010	====> 011
											  // index: 2 	001 | 001<<2 ==> 100	====> 111
		// 비선택
		generateSubset(index+1,flag);*/
	}

}
