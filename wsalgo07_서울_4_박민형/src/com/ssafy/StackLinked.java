package com.ssafy;

public class StackLinked {

	private static class Node{
		Object data;
		Node next;
		
		Node(){	}
		Node(Object data){
			this.data = data;
		}
		Node(Object data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public int size;
	public Node head;
	
	public StackLinked() {
		size = 0;
		head = null;
	}
	
	public void push(Object data) {
		Node newNode = new Node(data);
		
		if(head != null) {
			newNode.next = head;
		}
		head = newNode;
		++size;
	}
	
	public Object pop() {
		if(size==0)return null;
		Node tempNode = head;
		head = tempNode.next;
		tempNode.next = null;
		--size;
		return tempNode.data;
	}
	public int size() {
		return size;
	}
	public Object peek() {
		if(size==0)return null;
		return head.data;
	}
	public void printList() {
		Node currNode = head;
		System.out.print("stack = [ ");
		while(currNode != null) {
			System.out.print(currNode.data+" ");
			currNode = currNode.next;
		}
		System.out.println("]");
	}
	
	
	
}
