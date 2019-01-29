package com.ssafy.tree;

public class BinaryTree {

	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	private final int MAX_LEVEL;
	
	public BinaryTree(int size) {
		super();
		this.SIZE = size;
		nodes = new Object[SIZE+1];
		
		int count = 0;
		for(int base=1;base<=SIZE; base<<=1,count++);
		MAX_LEVEL = count-1;
	}
	public boolean isEmpty() {
		return lastIndex==0;
	}
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(Object e) {
		if(isFull()) {
			System.out.println("포화상태입니다");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	public void printTreeByLevelOrder() {
		int start,end;
		for(int i=0;i<=MAX_LEVEL;++i) {
			start = (int)Math.pow(2, i);
			end = (int)Math.pow(2, i+1)-1;
			for(int j=start;j<=lastIndex&&j<=end;++j) {
				System.out.print(nodes[j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//전위
	public void printTreeByPreOrder() {
		printTreeByPreOrder(1);
		System.out.println();
	}
	private void printTreeByPreOrder(int current) {//CLR
		if(current<=lastIndex) {
			System.out.print(nodes[current]+" ");
			printTreeByPreOrder(current*2);
			printTreeByPreOrder(current*2+1);
		}
	}
	
	//중위
	public void printTreeByInOrder() {
		printTreeByInOrder(1);
		System.out.println();
	}
	private void printTreeByInOrder(int current) {//CLR
		if(current<=lastIndex) {
			printTreeByInOrder(current*2);
			System.out.print(nodes[current]+" ");
			printTreeByInOrder(current*2+1);
		}
	}
	
	//후위
	public void printTreeByPostOrder() {
		printTreeByPostOrder(1);
		System.out.println();
	}
	private void printTreeByPostOrder(int current) {//CLR
		if(current<=lastIndex) {
			printTreeByPostOrder(current*2);
			printTreeByPostOrder(current*2+1);
			System.out.print(nodes[current]+" ");
		}
	}
	
}
