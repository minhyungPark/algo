package com.ssafy.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Soulution2063_CountSort {

	public static void main(String[] args) throws FileNotFoundException{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int result=0;
		int[] count = new int[200];
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;++i) {
			arr[i] = sc.nextInt();
			count[arr[i]]++;
			if(min>arr[i])min=arr[i];
			if(max<arr[i])max=arr[i];
		}
		
		for(int i=min;i<=max;++i) {
			if(i>0)count[i]=count[i-1]+count[i];
			if(count[i]>=N/2+1) {
				result=i;
				break;
			}
		}
		
		System.out.println(result);
		
		
	}

}
