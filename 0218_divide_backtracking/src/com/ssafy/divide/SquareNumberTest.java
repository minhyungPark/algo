package com.ssafy.divide;

public class SquareNumberTest {

	public static int power(int x,int y) {
		if(y==1) {
			return x;
		}else if(y%2==0) { // 짝수 지수
			int result = power(x,y/2);
			return result * result;
		}else { // 홀수 지수
			int result = power(x,(y-1)/2);
			return result*result*x;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(power(2,31));
	}

}
