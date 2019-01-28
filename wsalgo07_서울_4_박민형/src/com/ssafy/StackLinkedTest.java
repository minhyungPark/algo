package com.ssafy;

public class StackLinkedTest {

	public static void main(String[] args) {
		StackLinked stack = new StackLinked();
		stack.printList();
		stack.push("1");
		stack.printList();
		System.out.println("size: "+stack.size());
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");
		stack.push("6");
		stack.push("7");
		stack.printList();
		System.out.println("size: "+stack.size());
		System.out.println(stack.pop());
		stack.printList();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("size: "+stack.size());
	}

}
