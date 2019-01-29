package com.ssafy.tree;

public class TreeNode {

	Object data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {}
	public TreeNode(Object data,TreeNode left,TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public TreeNode(Object data) {
		this.data = data;
	}
}
