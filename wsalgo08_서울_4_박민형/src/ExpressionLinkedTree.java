

import java.util.Stack;

public class ExpressionLinkedTree {

	private TreeNode root;

	//후위표기식 받음
	public void makeTree(String postExpression) {
		
		Stack<TreeNode> stack  = new Stack<TreeNode>();
		int length = postExpression.length();
		char c;
		TreeNode node = null;
		for(int i=0;i<length;++i) {
			c = postExpression.charAt(i);
			node = new TreeNode(c);
			switch (c) {
			case '+':case '-':case '*':case '/':
				node.right = stack.pop();
				node.left = stack.pop();
				break;
			}
			stack.push(node);
		}
		root = stack.pop();
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
