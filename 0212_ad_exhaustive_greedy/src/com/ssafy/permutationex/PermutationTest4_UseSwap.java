package com.ssafy.permutationex;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest4_UseSwap {

	static int[] number;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 3;
		number = new int[] {1,2,3};		// Permutation(3,3) = Combination(3,3) * Factorial(3) 
		permutation(0);
	}
	
	private static void permutation(int index) {
		if(index==N) {
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i=index;i<N;++i) {
			swap(index,i);
			permutation(index+1);
			swap(index,i);
		}
		
	}

	private static void swap(int x, int y) {
		int temp = number[x];
		number[x] = number[y];
		number[y] = temp;
	}

}
