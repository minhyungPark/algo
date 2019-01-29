

public class ExpressionLinkedTreeTest {

	public static void main(String[] args) {
		String postExpression = "12*34-+";
		ExpressionLinkedTree tree = new ExpressionLinkedTree();
		tree.makeTree(postExpression);
		
		tree.printTreeByPreOrder();
		tree.printTreeByInOrder();
		tree.printTreeByPostOrder();

	}

}
