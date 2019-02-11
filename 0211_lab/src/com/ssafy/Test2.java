package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

//01D06079861D79F99F

public class Test2 {

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
//		System.out.println(Arrays.toString(bits));
		
		int i=0, count=7;
		int size1=(bits.length/count)*7;
		int size2=bits.length%7;

		while(i<size1) {
			int number=0;
			for(int j=0;j<count;++j) {
				if(bits[i+j]==0)continue;
				number += (1<<(count-1-j));
			}
			System.out.println(number);
			i+=count;
		}
		if(size2>0) {
			int number=0;
			for(int j=0;j<size2;++j) {
				if(bits[size1+j]==0)continue;
				number += (1<<(size2-1-j));
			}
			System.out.println(number);
		}
	}

}
