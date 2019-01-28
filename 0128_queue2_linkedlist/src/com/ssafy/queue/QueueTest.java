package com.ssafy.queue;

public class QueueTest {

	public static void main(String[] args) {
		
		CircularQueue queue = new CircularQueue(4);
		queue.enQueue("김재환");
		queue.enQueue("강다니엘");
		queue.enQueue("황민현");
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		queue.enQueue("김태희");
		System.out.println(queue.peek());
	}
}
