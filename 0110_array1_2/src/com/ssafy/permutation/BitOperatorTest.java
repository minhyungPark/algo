package com.ssafy.permutation;

public class BitOperatorTest {

	public static void main(String[] args) {

		// &, |, <<, >>, >>>, ^(XOR), ~
		
		int i = 1<<1;
		int j = 5;
		
		System.out.println(i);
		System.out.println("i = \t"+Integer.toBinaryString(i));
		System.out.println("j = \t"+Integer.toBinaryString(j));
		System.out.println("j&i = \t"+(j&i));
		System.out.println("j&i = \t"+Integer.toBinaryString(i&j));
		System.out.println("j|i = \t"+(j|i));
		System.out.println("j|i = \t"+Integer.toBinaryString(i|j));
		
		
	}

}
