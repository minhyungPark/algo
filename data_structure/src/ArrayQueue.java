
public class ArrayQueue {

	private int front;
	private int rear;
	private int maxSize;
	private int size;
	private Object[] queueArray;
	
	public ArrayQueue(int maxSize) {
		this.front = 0;
		this.rear = -1;
		this.size = 0;
		this.maxSize = maxSize;
	}
	
	public boolean isEmpty() {
		return (front == rear+1);
	}
	
	public boolean isFully() {
		return (rear==maxSize-1);
	}
	
	public void insert(Object item) {
		if(isFully()) throw new ArrayIndexOutOfBoundsException();
		
		queueArray[++rear] = item;
	}
	
	public Object peek() {
		if(isEmpty())return null;
		return queueArray[front];
	}
	
	public Object poll() {
		if(isEmpty())return null;
		return queueArray[front++];
	}
	
}
