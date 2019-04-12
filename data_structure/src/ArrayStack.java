public class ArrayStack {

	private int top;
	private Object[] stack;
	private int maxSize;
	
	public ArrayStack(int maxSize) {
		top = -1;
		this.maxSize = maxSize;
		stack = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	public boolean isFull() {
		return top+1==maxSize;
	}
	public int size() {
		return top+1;
	}
	public void push(Object temp) {
		if(isFull()) {
			System.out.println("포화 상태");
			return;
		}
		stack[++top] = temp;
	}
	public Object pop() {
		if(isEmpty()) {
			System.out.println("공백상태");
			return null;
		}
		return stack[top--];
	}
}
