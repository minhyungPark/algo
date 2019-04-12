
public class LinkedList {

	private static class Node{
		Object data;
		Node next;
		Node(Object data){
			this.data = data;
			this.next = null;
		}
		Node(Object data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	private Node head;
	private Node tail;
	public LinkedList() {
		head = tail = null;
	}
	
	// 마지막 노드 찾기
	public Node getLastNode() {
		return tail;
	}
	// 특정 노드의 바로 이전 노드 찾기
	public Node getPreviousNode(Node node) {
		Node temp = head;
		if(temp==null) return null;
		while(temp.next!=null) {
			if(temp.next==node)return temp;
			temp = temp.next;
		}
		return null;
	}
	
	// 마지막 노드로 추가
	public void addLastNode(Object data) {
		Node temp = new Node(data);
		if(tail==null) {
			head = temp;
			tail = temp;
		}else {
			tail.next = temp;
			tail = temp;
		}
	}
	
	// 첫번째 노드로 추가
	public void addFirstNode(Object data) {
		Node temp = new Node(data);
		if(head==null) {
			head = temp;
			tail = temp;
		}else {
			temp.next = head;
			head = temp;
		}
	}
	
	// 지정한 뒤에 추가
	public void insertAfterNode(Node preNode,Object data) {
		if(preNode!=null) {
			Node temp = new Node(data,preNode.next);
			preNode.next = temp;
		}else {
			addFirstNode(data);
		}
	}
	
	// 원하는 노드 찾기
	public Node getNode(Object data) {
		Node temp = head;
		while(temp!=null) {
			if(temp.data==data)return temp;
			temp=temp.next;
		}
		return null;
	}
	// 마지막 노드 삭제
	public void deleteLastNode() {
		if(tail!=null) {
			Node pre = getPreviousNode(tail);
			if(pre==null) {
				head=null;
				tail=null;
			}else {
				pre.next = null;
				tail = pre;
			}
		}
	}
	// 출력
	public void printList() {
		Node currNode = head;
		System.out.print("LinkedList = [ ");
		while(currNode != null) {
			System.out.print(currNode.data+" ");
			currNode = currNode.next;
		}
		System.out.println("]");
	}
	
}
