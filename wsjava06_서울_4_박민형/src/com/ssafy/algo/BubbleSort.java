package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("BubbleSort.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	//Test case
		
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();	//받을 숫자의 개수
			int[] arr = new int[N];
			for(int i=0;i<arr.length;++i) {
				arr[i] = sc.nextInt();
			}// 입력 끝
			
			//Bubble sort
			for(int i=0;i<arr.length-1;++i) {
				for(int j=0;j<arr.length-i-1;++j) {
					if(arr[j]>arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
			//출력
			for(int i=0;i<arr.length;++i) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
	}

}
