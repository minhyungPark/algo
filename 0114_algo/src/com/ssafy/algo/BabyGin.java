package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class BabyGin {

	static int N;
	static int M;
	static int selected;
	static int[] number;
	static boolean bG;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = 6;
		M = 6;
		number = new int[M];
		selected = 0;
		
		int T = Integer.parseInt(sc.nextLine());
		for(int t=1;t<=T;++t) {
			bG = false;
			int ans = Integer.parseInt(sc.nextLine());
			int[] num = new int[N];
			for(int i=0;i<N;++i) {
				num[i] = ans%10;
				ans = ans/10;
			}
			permutation(num,0);
			if(bG) System.out.println("Baby-gin");
			else System.out.println("non-Baby-gin");
		}
	}

	private static void permutation(int[] num, int index) {
		if(index==M) {
			int[] n1 = Arrays.copyOfRange(number, 0, 3);
			int[] n2 = Arrays.copyOfRange(number, 3, 6);
//			System.out.println(Arrays.toString(number));
			if(run(n1)&&run(n2)) { 
				bG = true;
				return;
			}
			if(triplet(n1)&&run(n2)) {
				bG = true;
				return;
			}
			if(triplet(n1)&&triplet(n2)) {
				bG = true;
				return;
			}
		}
		
		for(int i=0;i<N;++i) {
			if((selected&(1<<(i-1)))==0) {
				number[index] = num[i];
				selected = selected | (1<<(i-1));
				permutation(num,index+1);
				selected = selected^(1<<(i-1));
			}
		}
	}

	private static boolean triplet(int[] n) {
		if(n[0]==n[1]&&n[1]==n[2])return true;
		return false;
	}

	private static boolean run(int[] n) {
		if(n[1]==n[0]+1&&n[2]==n[1]+1) {
			return true;
		}
		return false;
	}
}
