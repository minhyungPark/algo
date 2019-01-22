package com.ssafy.array;


public class Gravity {

	public static void main(String[] args) {
		
		int N = 10;
//		int[] data = {7,4,2,0,0,6,0,7,0};
		int[] data = new int[N];
		
		for(int i=0;i<data.length;++i) {
			data[i] = (int)(Math.random()*(N+1));
//			System.out.print(data[i]+" ");
		}
		System.out.println();
		int result=0;
		int key = 0;
		for(int i=0;i<data.length-1;++i) {
			int cnt=0;
			for(int j=i+1;j<data.length;++j) {
				if(data[i]>data[j]) {
					++cnt;
				}
			}
			if(result<cnt) {
				result = cnt;
				key = i;
			}
		}
		
		/*for(int i=0;i<data.length;++i) {
			for(int j=0;j<data[i];++j) {
				System.out.print("■");
			}
			System.out.println();
		}
		System.out.println("=========================");*/
		System.out.println(result);
//		System.out.println(key);
	}

}
