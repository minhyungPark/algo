package com.ssafy.linkedlist;

public class Node {

	public Object data;
	public Node next;
	
	public Node(Object data,Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Node(Object data) {
		super();
		this.data = data;
	}
	public Node() {
		super();
	}
	
}
