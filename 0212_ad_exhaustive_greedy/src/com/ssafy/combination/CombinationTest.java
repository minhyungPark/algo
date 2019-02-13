package com.ssafy.combination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CombinationTest {

	static int[] arr;
	static int[] number;
	static int N;
	static int M;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		number = new int[M];
		for(int i=0;i<N;++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		combination(0,0);
		System.out.print(sb.toString());
	}
	private static void combination(int index, int valueIndex) {
		if(index==M) {
			for(int i=0;i<M-1;++i) {
				sb.append(number[i]).append(" ");
			}
			sb.append(number[M-1]);
			sb.append("\n");
			return;
		}
		for(int i=valueIndex;i<N;++i) {
			number[index] = arr[i];
			combination(index+1,i+1);
		}
	}

}
