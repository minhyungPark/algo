
public class LinkedStack {

	private Node top;
	private int size;
	
	private static class Node{
		Object data;
		Node next;
		Node(Object data){
			this.data = data;
			next = null;
		}
	}
	public LinkedStack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void push(Object data) {
		Node temp = new Node(data);
		if(top!=null)top.next = temp;
		top = temp;
		++size;
	}
	
	public Object peek() {
		return top!=null?top.data:null;
	}
	public int size() {
		return size;
	}
	
	public Object pop() {
		if(isEmpty())return null;
		Object temp = peek();
		top = top.next;
		size--;
		return temp;
	}
	
	
}
