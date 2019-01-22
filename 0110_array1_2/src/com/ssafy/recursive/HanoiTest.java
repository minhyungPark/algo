package com.ssafy.recursive;

import java.util.Scanner;

public class HanoiTest {

	
	// n개 원판 1 --> 3
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(N, 1, 2, 3);
	}

	private static void hanoi(int n, int from, int temp, int to) {
		
		if(n>1) {
			// n-1개 임시기둥으로 옮기기
			hanoi(n-1,from,to,temp);
			// n번째 밑장 목적기둥으로 옮기기
			System.out.println(n+" : "+from+" -> "+to);
			// 임시기둥에 있는 n-1개 목적 기둥으로 옮기기
			hanoi(n-1,temp,from,to);
		}else {
			System.out.println(n+" : "+from+" -> "+to);
		}
	}
}
