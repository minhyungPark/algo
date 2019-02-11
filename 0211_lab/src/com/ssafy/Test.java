package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

//0269FAC9A0
//0DEC
public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int[] bits = new int[line.length()*4];
		char c;
		int temp,qutotient,remainder,b=0;
		for(int i=0;i<line.length();++i) {
			c = line.charAt(i);
			if('0'<=c&&c<='9') {
				temp = c-'0';
			}else {
				temp = c-'A'+10;
			}
			int j=3;
			while(true) {
				qutotient = temp/2;
				remainder = temp%2;
				bits[b+j] = remainder;
				j--;
				temp = qutotient;
				if(temp==0)break;
			}
			b+=4;
		}
		for(int i=0;i<bits.length;++i) {
			System.out.print(bits[i]);
		}
		System.out.println();
//		System.out.println(Arrays.toString(bits));
		StringBuilder sb = new StringBuilder();
		String[] numbers= {"001101","010011","111011","110001","100011","110111","001011","111101","011001","101111"};
		for(int i=0;i<bits.length;++i) {
			if(bits[i]==0) {
				sb.append("0");
			}else if(bits[i]==1) {
				sb.append("1");
			}
		}
		String bit = sb.toString();
		for(int i=0;i<bit.length()-6;) {
			String tempString = bit.substring(i, i+6);
			for(int j=0;j<numbers.length;++j) {
				if(tempString.equals(numbers[j])) {
					System.out.print(j+" ");
					i+=5;
					break;
				}
			}
			++i;
		}
		System.out.println();
	}

}
