package com.ssafy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
	/*	ArrayQueue queue = new ArrayQueue(4);
		queue.enQueue("김재환");
		queue.enQueue("강다니엘");
		queue.enQueue("황민현");
		queue.enQueue("박보검");
		queue.enQueue("정해인");
		System.out.println(queue.peek());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	*/	
		Queue<String> queue2 = new LinkedList<String>();
		queue2.offer("김재환");
		queue2.offer("강다니엘");
		queue2.offer("황민현");
		queue2.offer("박보검");
		queue2.offer("정해인");
		System.out.println(queue2.peek());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.poll());
		System.out.println(queue2.remove());
		
	}
}
