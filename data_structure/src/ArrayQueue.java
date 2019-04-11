
public class ArrayQueue {

	private int front;
	private int rear;
	private int maxSize;
	private Object[] que;
	
	public ArrayQueue(int maxSize) {
		this.front = -1;
		this.rear = -1;
		this.maxSize = maxSize;
		que = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return front==rear;
	}
	
	public boolean isFully() {
		return (rear==maxSize-1);
	}
	
	public void enQueue(Object item) {
		if(isFully()) {
			System.out.println("que가 포화상태입니다");
			return;
		}
		
		que[++rear] = item;
	}
	
	public Object peek() {
		if(isEmpty())return null;
		return que[front+1];
	}
	
	public Object deQueue() {
		if(isEmpty())return null;
		return que[front++];
	}
	
	public int size() {
		return rear-front;
	}
}
