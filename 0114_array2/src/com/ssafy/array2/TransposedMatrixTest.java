package com.ssafy.array2;

import java.util.Arrays;

public class TransposedMatrixTest {

	private static int[][] matrix = {
			{1,2,3},{4,5,6},{7,8,9}
	};
	private static final int N =3;
	public static void main(String[] args) {
		print();
		transpose();
		print();
	}
	private static void swap(int a,int b,int c,int d) {
		int temp=matrix[a][b];
		matrix[a][b]=matrix[c][d];
		matrix[c][d]=temp;
	}
	private static void transpose() {
		for(int i=0;i<N;++i) {
			for(int j=i+1;j<N;++j) {
				swap(i,j,j,i);
			}
		}
	}
	private static void print() {
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println("=========================");
	}
}
