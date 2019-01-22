package com.ssafy.stack;

import java.util.Stack;

class ArrayStack2 {

	private String stack[];
	private int top = -1;
	private int size;
	
	public ArrayStack2(int size) {
		stack = new String[size];
		this.size = size;
	}
	public void push(String element) {
		if(top == size-1) {
			System.out.println("스택이 포화상태입니다");
			return;
		}
		stack[++top] = element;
	}
	public String pop() {
		String element = peek();
		if(element!=null) {
			stack[top--]=null;
		}
		return	element; 
	}
	public String peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다");
			return null;
		}
		return stack[top];
	}
	public boolean isEmpty() {
		return top==-1;
	}
	public int size() {
		return top+1;
	}

}

public class ArrayStackTest {

	public static void main(String[] args) {

		ArrayStack2 stack = new ArrayStack2(5);
//		Stack stack = new Stack();
		stack.push("김재환");
		stack.push("강다니엘");
		stack.push("황민현");
		stack.push("이지은");
		stack.push("김재웅");
		
		System.out.println("============================");
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}
