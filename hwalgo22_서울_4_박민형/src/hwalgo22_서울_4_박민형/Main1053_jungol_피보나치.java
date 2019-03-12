package hwalgo22_서울_4_박민형;

import java.util.Scanner;

public class Main1053_jungol_피보나치 {

	static int[][] arr = {{1,1},{1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			long N = sc.nextLong();
			if(N==-1)break;
			if(N==0) {
				System.out.println(0);
				continue;
			}
			int[][] result = go(N);
			System.out.println(result[0][1]);
		}
	}
	private static int[][] go(long n) {
		if(n==1) {
			return arr;
		}
		
		if(n%2==0) {
			int[][] temp = go(n/2);
			return mul(temp,temp);
		}else {
			int[][] temp = go(n/2);
			return mul(arr,mul(temp,temp));
		}
		
	}
	private static int[][] mul(int[][] a,int[][] b){
		int[][] temp = new int[2][2];
		temp[0][0] = (a[0][0]*b[0][0]+a[0][1]*b[1][0])%10000;
		temp[1][0] = (a[1][0]*b[0][0]+a[1][1]*b[1][0])%10000; 
		temp[0][1] = (a[0][0]*b[0][1]+a[0][1]*b[1][1])%10000;
		temp[1][1] = (a[1][0]*b[0][1]+a[1][1]*b[1][1])%10000; 
		return temp;
	}

}
