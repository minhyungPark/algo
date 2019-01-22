package com.ssafy.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Top {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Solution.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] top;
		int receiveNo;
		Stack<Integer> stack = new Stack<>();
		for( int t=1;t<=T;++t) {
			StringBuilder receive = new StringBuilder();
			int N = sc.nextInt();
			top  = new int[N];
			receiveNo = 0;
			
			for(int i=0;i<N;++i) {
				top[i] =sc.nextInt();
				while(!stack.isEmpty() && top[stack.peek()]<=top[i])stack.pop();
				if(!stack.isEmpty()) receiveNo = stack.peek()+1;
				stack.push(i);
				
				receive.append(receiveNo).append(" ");
			}
			System.out.println(receive.toString());
		}
		
	}

}
