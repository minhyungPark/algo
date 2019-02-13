package com.ssafy.permutation;

import java.util.Arrays;

public class PermutationTest4 {

	static int N ,numbers[];
	static boolean[] selected;
	
	public static void main(String[] args) {
		N=4;
		//1,2,3
		selected = new boolean[N+1];
		numbers = new int[N];
		permutation(0);
		
		
	}
	private static void permutation(int index) {
		
		if(index == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//1���� N���� �õ�
		for(int i=1; i<=N; ++i) {
			// �õ��ϴ� ���� �����ڸ������� ������ �ʾҴٸ�
			if(!selected[i]) {
				numbers[index] = i;
				selected[i] = true;
				permutation(index+1);
				selected[i] = false;
			}
		}
	}

}










