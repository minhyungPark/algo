package com.ssafy.permutation;

public class PermutationTest2 {

	public static void main(String[] args) {
		
		//1,2,3 를 2자리수 순열
		for(int i=1;i<=3;++i) {
			for(int j=1;j<=3;++j) {
				if(i!=j) {
					System.out.println(i+" "+j);
				}
			}
		}
		
		
		
	}
}
