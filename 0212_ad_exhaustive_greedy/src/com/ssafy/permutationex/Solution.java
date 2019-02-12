package com.ssafy.permutationex;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] arr;
	static int[] number;
	static int N;
	static int M;
	static boolean[] check;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		check = new boolean[N];
		number = new int[M];
		
		for(int i=0;i<N;++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permutation(0);
		System.out.print(sb.toString());
	}
	private static void permutation(int index) {
		if(index==M) {
			for(int i=0;i<M;++i) {
				sb.append(number[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;++i) {
			if(!check[i]) {
				check[i] = true;
				number[index] = arr[i];
				permutation(index+1);
				check[i] = false;
			}
		}
		
	}

}
