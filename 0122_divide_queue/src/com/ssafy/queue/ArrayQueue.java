package com.ssafy.queue;

public class ArrayQueue {

	private Object[] queue;
	final int MAX_SIZE;
	private int front, rear;

	public ArrayQueue(int maxSize) {
		super();
		MAX_SIZE = maxSize;
		queue = new Object[MAX_SIZE];
		front = rear = -1;
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
	public boolean isFull() {
		return rear == MAX_SIZE-1;
	}
	public void enQueue(Object item) {
		if(isFull()) {
			System.out.println("포화상태이어서 enqueue 불가능");
			return;
		}
		queue[++rear] = item;
	}
	public Object deQueue() {
		Object item = peek();
		if(item != null) {
			queue[++front] = null;
		}
		return item;
	}
	public Object peek() {
		if(isEmpty()) {
			System.out.println("공백상태입니다");
			return null;
		}
		return queue[front+1];
	}

}
