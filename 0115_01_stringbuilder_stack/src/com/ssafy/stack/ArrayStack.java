package com.ssafy.stack;

public class ArrayStack {

	private String stack[];
	private int top = -1;
	private int size;
	
	public ArrayStack(int size) {
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
