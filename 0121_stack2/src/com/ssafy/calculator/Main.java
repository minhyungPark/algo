package com.ssafy.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	// 중위 표현식 ==> 후위 표현식으로 변환
	public static String toPostFix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] chars = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		final int SIZE = chars.length;
		char temp;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			int p = priority(temp);
			switch (temp) {
			case '(':
				stack.push(temp);
				break;
			case ')':
				while(stack.peek()=='(') {
					postfix.append(stack.pop());
				}
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				if(priority(stack.peek())>priority(temp)) {
					postfix.append(stack.pop());
				}else {
					stack.push(temp);
				}
				break;

			default:
				postfix.append(chars[i]);
				break;
			}
		}
		return postfix.toString();
		
	}
	
	
	private static int priority(char temp) {
		int p=0;
		switch (temp) {
		case '(':
			p=3;
			break;
		case '+':
		case '-':
			p=1;
			break;
		case '*':
		case '/':
			p=2;
			break;

		default:
			break;
		}
		return p;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(toPostFix(bf.readLine()));
	}

}
