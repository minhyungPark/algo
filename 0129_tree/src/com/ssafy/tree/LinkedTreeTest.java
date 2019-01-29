package com.ssafy.tree;

import java.util.Scanner;

public class LinkedTreeTest {

//	13
//	1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int edgeCnt = sc.nextInt()-1;

		LinkedTree tree = new LinkedTree();
		for(int i=0;i<edgeCnt;++i) {
			tree.add(sc.nextInt(), sc.nextInt());
		}
		tree.printTreeByPreOrder();
		tree.printTreeByInOrder();
		tree.printTreeByPostOrder();
	}

}
