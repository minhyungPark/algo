package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;++i) {
				arr[i] = sc.nextInt();
			}
			// 입력끝
			int[] result = new int[n];
			for(int i=0;i<n;++i) {
				for(int j=i-1;j>=0;--j) {
					if(arr[j]>=arr[i]) {
						result[i] = j+1;
						break;
					}
				}
				
			}
			System.out.print("#"+t+" ");
			for (int r : result) {
				System.out.print(r+" ");
			}
			System.out.println();
			
			
			
		}
		
		
	}

}
