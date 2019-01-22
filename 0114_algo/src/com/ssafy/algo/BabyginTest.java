package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BabyginTest {

	static int[][] permutationList;
	static int p; // 순열 리스트의 index
	static int N = 6;
	static int[] numbers;
	
	private static void permutation(int count,int flag) {
		
		if(count == N ) {
			permutationList[p++] = Arrays.copyOf(numbers, N);
//			System.out.println(Arrays.toString(permutationList[p-1]));
			return;
		}
		
		for(int i=0;i<N;++i) {
			if((flag& 1<<i) == 0) {
				numbers[count] = i;
				permutation(count+1,flag | 1<<i);
			}
		}
	}
	
	private static boolean isBabygin(int n) {
		int run=0, triplet=0;
		
		int[] indexes = permutationList[n];
		if(numbers[indexes[0]] == numbers[indexes[1]] && numbers[indexes[0]] == numbers[indexes[2]]) triplet++;
		if(numbers[indexes[3]] == numbers[indexes[4]] && numbers[indexes[3]] == numbers[indexes[5]]) triplet++;
		if(numbers[indexes[0]]+1 == numbers[indexes[1]] && numbers[indexes[0]]+2 == numbers[indexes[2]]) run++;
		if(numbers[indexes[3]]+1 == numbers[indexes[4]] && numbers[indexes[3]]+2 == numbers[indexes[5]]) run++;
		
		return run+triplet==2?true:false;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = 1;
		for(int i=1;i<=N;++i) size *=i;			// N 일때, 순열의 경우의 수
		permutationList = new int[size][N];
		numbers = new int[N];
		permutation(0,0);						// index 순열 생성
		
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			char[] data = sc.next().toCharArray();
			for(int i=0;i<N;++i) {
				numbers[i] = data[i]-'0';
			}
			boolean check = false;
			for(int i=0;i<size;++i) {
				if(isBabygin(i)) {
					check = true;
					break;
				}
			}
			System.out.println("#"+t+" is "+(check?"Baby-gin": "not Baby-gin"));
		}
	}
}
