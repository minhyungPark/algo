package com.ssafy.tree;

public class LinkedTree {

	private TreeNode root;
	private int size;
	
	public void add(Object pData,Object data) {
		TreeNode pNode = getNode(root,pData);
		TreeNode newNode = new TreeNode(data);
		if(pNode == null && size==0) {			// 부모 노드가 없으니 부모노드 생성해서 루트로 연결할 자식으로 add
			root = pNode = new TreeNode(pData);
			size++;
		}else if(pNode==null){
			System.out.println("찾는 부모노드가 존재하지 않아 추가할 수 없습니다.");
			return;
		}
		
		if(pNode.left == null) {
			pNode.left = newNode;
			size++;
		}else if(pNode.right == null) {
			pNode.right = newNode;
			size++;
		}
		
	}
	public TreeNode getNode(TreeNode node,Object data) {
		TreeNode temp;
		if(node == null) return null;
		if(node.data.equals(data))return node;
		temp = getNode(node.left,data);
		if(temp==null)temp = getNode(node.right,data);
		return temp;
	}
	
	
	//전위
	public void printTreeByPreOrder() {
		printTreeByPreOrder(root);
		System.out.println();
	}
	private void printTreeByPreOrder(TreeNode node) {//CLR
		if(node!=null) {
			System.out.print(node.data+" ");
			printTreeByPreOrder(node.left);
			printTreeByPreOrder(node.right);
		}
	}
	
	
	//중위
	public void printTreeByInOrder() {
		printTreeByInOrder(root);
		System.out.println();
	}
	private void printTreeByInOrder(TreeNode node) {//CLR
		if(node!=null) {
			printTreeByInOrder(node.left);
			System.out.print(node.data+" ");
			printTreeByInOrder(node.right);
		}
	}
	
	//후위
	public void printTreeByPostOrder() {
		printTreeByPostOrder(root);
		System.out.println();
	}
	private void printTreeByPostOrder(TreeNode node) {//CLR
		if(node!=null) {
			printTreeByPostOrder(node.left);
			printTreeByPostOrder(node.right);
			System.out.print(node.data+" ");
		}
	}
	
	
	
}
