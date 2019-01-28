package com.ssafy.linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.addLastNode("김재환");
		list.printList();

		list.addLastNode("김재웅");
		list.printList();
		list.addFirstNode("이지은");
		list.printList();
		
		Node node = list.getNode("김재웅");
		list.insertAfterNode(node, "조우현");
		list.printList();
		list.insertAfterNode(node, "박건욱");
		list.printList();
		list.deleteLastNode();
		list.printList();
		list.deleteLastNode();
		list.printList();
		list.deleteLastNode();
		list.printList();
		list.deleteLastNode();
		list.printList();
		list.deleteLastNode();
		list.printList();
	}

}
