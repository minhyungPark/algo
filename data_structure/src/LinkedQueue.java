
public class LinkedQueue {

	private static class Node{
		Object data;
		Node next;
		
		Node(Object data,Node next){
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedQueue() {
		size = 0;
		head=tail=null;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enQueue(Object item) {
		Node temp = new Node(item,null);
		if(head==null)head = temp;
		if(tail!=null)tail.next = temp;
		tail = temp;
		size++;
	}
	public Object peek() {
		if(isEmpty()) {
			System.out.println("공백상태");
			return null;
		}
		return head.data;
	}
	public int size() {
		return size;
	}
	
	public Object deQueue() {
		Object temp = peek();
		if(temp!=null) {
			Node tNode = head;
			head = head.next;
			tNode.next = null;
			--size;
		}
		return temp;
	}
	
	
}
