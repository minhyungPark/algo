
public class CircularQueue {

	private int rear;
	private int front;
	private int maxSize;
	private Object[] queue;
	
	public CircularQueue(int maxSize) {
		rear = 0;
		front = 0;
		this.maxSize = maxSize;
		queue = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return rear==front;
	}

	public boolean isFully() {
		return (rear+1)%maxSize==front;
	}
	
	public void enQueue(Object item) {
		if(isFully()) {
			System.out.println("포화 상태");
			return;
		}
		queue[++rear%maxSize] = item;
	}
	
	public Object deQueue() {
		Object temp = peek();
		if(temp!=null)queue[++front%maxSize] = null;
		return temp;
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("공백 상태");
			return null;
		}
		return queue[(front+1)%maxSize];
	}
	
	
}
