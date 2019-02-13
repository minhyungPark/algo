package com.ssafy.permutation;

import java.util.Arrays;

public class PermutationTest3 {

	static int N ,R,numbers[];
	static boolean[] selected;
	static StringBuilder sb;//
	public static void main(String[] args) {
		N=10;
		R=6;
		selected = new boolean[N+1];
		numbers = new int[R];
		sb = new StringBuilder();//
		permutation(0);
		System.out.println(sb.toString());
	}
	private static void permutation(int index) {
		
		if(index == R) {
			sb.append(Arrays.toString(numbers)+"\n");
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//1부터 N까지 시도
		for(int i=1; i<=N; ++i) {
			// 시도하는 수가 기존자리수까지 사용되지 않았다면
			if(!selected[i]) {
				numbers[index] = i;
				selected[i] = true;
				permutation(index+1);
				selected[i] = false;
			}
		}
	}

}










