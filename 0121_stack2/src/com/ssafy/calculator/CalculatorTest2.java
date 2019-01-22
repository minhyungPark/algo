package com.ssafy.calculator;

import java.util.Stack;

public class CalculatorTest2 {

	// 중위 표현식 ==> 후위 표현식으로 변환
	public static String toPostFix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] chars = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		final int SIZE = chars.length;
		char temp;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			switch (temp) {
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
				postfix.append(temp);
				break;
			case ')':
				while(stack.peek()!='(') {
					postfix.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				if(stack.isEmpty()) {
					stack.push(temp);
				}else {
					if(getPriority(temp,false)>getPriority(stack.peek(), true)) {
						stack.push(temp);
					}else {
						while(!stack.isEmpty()&&getPriority(temp,false)<=getPriority(stack.peek(), true)) {
							postfix.append(stack.pop());
						}
						stack.push(temp);
					}
				}
				break;
			}
		}
		while(!stack.isEmpty())postfix.append(stack.pop());
		return postfix.toString();
	}
	
	public static int getPriority(char c,boolean b) {
		int p=0;
		switch (c) {
		case '(':
			if(b)p=0;
			else p=3;
			break;
		case '*':case '/':
			p=2;
			break;
		case '+':case '-':
			p=1;
			break;
		default:
			break;
		}
		return p;
	}

	

	public static void main(String[] args) {
//		String infix = "(2+(3*4))";
		String infix = "(6+5*(2-8)/2)";
		String postfix = toPostFix(infix);
		System.out.println(postfix);
		System.out.println(calculate(postfix));
	}
	
	
	private static double calculate(String postfix) {
		Stack<Double> stack = new Stack<Double>();
		char[] chars = postfix.toCharArray();
		final int SIZE = chars.length;
		char temp;
		double value1,value2;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			if(Character.isDigit(temp)) {
				double d = temp-'0';
				stack.push(d);
			}else {
				value2 = stack.pop();
				value1 = stack.pop();
				switch (temp) {
				case '+':
					stack.push(value1+value2);
					break;
				case '-':
					stack.push(value1-value2);
					break;
				case '*':
					stack.push(value1*value2);
					break;
				case '/':
					stack.push(value1/value2);
					break;

				default:
					break;
				}
			}
		}
		return stack.pop();
	}

}
