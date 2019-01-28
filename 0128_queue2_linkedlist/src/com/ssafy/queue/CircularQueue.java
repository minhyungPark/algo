package com.ssafy.queue;

public class CircularQueue {

	private Object[] queue;
	final int MAX_SIZE;
	private int front, rear;

	public CircularQueue(int maxSize) {
		super();
		MAX_SIZE = maxSize;
		queue = new Object[MAX_SIZE];
		front = rear = 0;				// 변경
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
	public boolean isFull() {
		return ((rear+1)%MAX_SIZE==front);	//변경
	}
	public void enQueue(Object item) {
		if(isFull()) {
			System.out.println("포화상태이어서 enqueue 불가능");
			return;
		}
		queue[++rear%MAX_SIZE] = item;	// 변경
	}
	public Object deQueue() {
		Object item = peek();
		if(item != null) {
			queue[++front%MAX_SIZE] = null;	// 변경
		}
		return item;
	}
	public Object peek() {
		if(isEmpty()) {
			System.out.println("공백상태입니다");
			return null;
		}
		return queue[(front+1)%MAX_SIZE];	// 변경
	}

}
