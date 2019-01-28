package com.ssafy.linkedlist;

public class LinkedList {
	
	private Node head;
	
	//마지막 노드 찾기
	public Node getLastNode() {
		Node currNode = head;
		if(currNode != null) {
			while(currNode.next!=null) {
				currNode = currNode.next;
			}
			return currNode;
		}
		return null;
	}
	
	//특정노드의 바로 이전 노드 찾기
	public Node getPreviousNode(Node node) {
		Node currNode = head;
		Node preNode = null;
		Node nextNode;
		if(currNode != null) {
			while((nextNode = currNode.next)!=null) {
				if(nextNode == node) {
//					return currNode;
					preNode = currNode;
					break;
				}
				currNode = nextNode;
			}
		}
		return preNode;
//		return null;
	}
	
	// 마지막 노드로 추가
	public void addLastNode(Object data) {
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		
		if(lastNode == null) {
			head = newNode;
		}else {
			lastNode.next = newNode;
		}
	}
	
	// 첫번째 노드로 추가
	public void addFirstNode(Object data) {
		Node newNode = new Node(data,head);
		head = newNode;
	}
	
	// 지정한 뒤에 추가
	public void insertAfterNode(Node preNode,Object data) {
		if(preNode!= null) {
			Node newNode = new Node(data,preNode.next);
			preNode.next = newNode;
		}else {
			addFirstNode(data);
		}
	}
	
	// 원하는 노드 찾기
	public Node getNode(Object data) {
		Node currNode = head;
		Node node=null;
		while(currNode != null){
			if(currNode.data == data) {
				node  = currNode;
				break;
			}
			currNode = currNode.next;
		}
		return node;
	}
	
	// 마지막 노드 삭제
	public void deleteLastNode() {
		Node lastNode = getLastNode();
		if(lastNode == null)return;
		Node preNode = getPreviousNode(lastNode);
		if(preNode != null) {		// 이전 노드가 있다면
			preNode.next = null;
		}else {						// 이전 노드가 없다면 (즉, 1개짜리 list라면)
			head = null;
		}
	}
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
