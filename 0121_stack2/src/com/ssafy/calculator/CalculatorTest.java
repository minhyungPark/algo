package com.ssafy.calculator;

import java.util.Stack;

public class CalculatorTest {

	// 중위 표현식 ==> 후위 표현식으로 변환
	public static String toPostFix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] chars = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		final int SIZE = chars.length;
		char temp;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			if(Character.isDigit(temp)) {
				postfix.append(temp);
			}else if(temp=='+'||temp=='-'||temp=='*'||temp=='/') {
				stack.push(temp);
			}else if(temp==')') {
				postfix.append(stack.pop());
			}
		}
		/*for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			switch (temp) {
			case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
				postfix.append(temp);
				break;
			case ')':
				postfix.append(stack.pop());
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				stack.push(temp);
				break;
			}
		}*/
		return postfix.toString();
		
	}

	

	public static void main(String[] args) {
//		String infix = "(2+(3*4))";
		String infix = "((2*6)-(8*4))";
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
