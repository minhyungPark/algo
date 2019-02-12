package com.ssafy.permutationex;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Solution3 {

	static int[] arr;
	static int[] number;
	static int N;
	static int M;
	static boolean[] check;
	static StringBuilder sb;
	static LinkedHashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		set = new LinkedHashSet<String>();
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
		for (String s : set) {
			System.out.println(s);
		}
	}
	private static void permutation(int index) {
		if(index==M) {
			StringBuilder builder = new StringBuilder();
			for (int n : number ) {
				builder.append(n).append(" ");
			}
			String result = builder.toString().trim();
			set.add(result);
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
