package com.ssafy.linkedlist;

public class DoubleLinkedList {
	
	private DoublyNode head;
	
	//마지막 노드 찾기
	public DoublyNode getLastNode() {
		DoublyNode currNode = head;
		if(currNode != null) {
			while(currNode.next!=null) {
				currNode = currNode.next;
			}
			return currNode;
		}
		return null;
	}
	
	//특정노드의 바로 이전 노드 찾기
	public DoublyNode getPreviousNode(DoublyNode node) {
		return node.prev;
	}
	
	// 마지막 노드로 추가
	public void addLastNode(Object data) {
		DoublyNode lastNode = getLastNode();
		DoublyNode newNode = new DoublyNode(data);
		
		if(lastNode == null) {
			head = newNode;
		}else {
			lastNode.next = newNode;
			newNode.prev = lastNode;						//변경
		}
	}
	
	// 첫번째 노드로 추가
	public void addFirstNode(Object data) {
		DoublyNode newNode = new DoublyNode(data);
		if(head!=null) head.prev = newNode;
		newNode.next = head;
		head = newNode;
	}
	
	// 지정한 뒤에 추가
	public void insertAfterNode(DoublyNode preNode,Object data) {
		if(preNode!= null) {
			DoublyNode afterNode = preNode.next;
			
			DoublyNode newNode = new DoublyNode(data,preNode,afterNode);
			
			preNode.next = newNode;
			if(afterNode != null) {
				afterNode.prev = newNode;
			}
		}else {
			addFirstNode(data);
		}
	}
	
	// 원하는 노드 찾기
	public DoublyNode getNode(Object data) {
		DoublyNode currNode = head;
		DoublyNode node=null;
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
		DoublyNode lastNode = getLastNode();
		if(lastNode == null)return;
		DoublyNode preNode = getPreviousNode(lastNode);
		if(preNode != null) {		// 이전 노드가 있다면
			preNode.next = null;
		}else {						// 이전 노드가 없다면 (즉, 1개짜리 list라면)
			head = null;
		}
		lastNode.prev = null;
	}
	public void printList() {
		DoublyNode currNode = head;
		System.out.print("LinkedList = [ ");
		while(currNode != null) {
			System.out.print(currNode.data+" ");
			currNode = currNode.next;
		}
		System.out.println("]");
	}

}
