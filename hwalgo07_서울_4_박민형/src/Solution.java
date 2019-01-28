import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static class Node{
		int data;
		Node next;

		Node(){	};
		Node(int data){
			this.data = data;
		}
		Node(int data,Node next){
			this.data = data;
			this.next = next;
		}
	}
	private static class Linked{
		Node head;
		Node next;
		int size;
		public Linked() {
			this.size=0;
		}
		
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
//						return currNode;
						preNode = currNode;
						break;
					}
					currNode = nextNode;
				}
			}
			return preNode;
//			return null;
		}
		
		// 마지막 노드로 추가
		public void addLastNode(int data) {
			Node lastNode = getLastNode();
			Node newNode = new Node(data);
			
			if(lastNode == null) {
				head = newNode;
			}else {
				lastNode.next = newNode;
			}
		}
		
		// 첫번째 노드로 추가
		public void addFirstNode(int data) {
			Node newNode = new Node(data,head);
			head = newNode;
		}
		
		// 지정한 뒤에 추가
		public void insertAfterNode(int index,int data) {
			Node currNode = head;
			int i=0;
			while(i>index) {
				currNode = currNode.next;
				++i;
			}
			Node newNode = new Node(data);
			Node temp = currNode.next;
			currNode.next = newNode;
			newNode.next = temp;
		}
		
		// 원하는 노드 찾기
		public Node getNode(int data) {
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
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			
		}
		Linked list = new Linked();
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int n=0;n<N;++n) {
			list.addLastNode(Integer.parseInt(st.nextToken()));
		}
		list.printList();
		N = Integer.parseInt(bf.readLine());
		for(int n=0;n<N;++n) {
			String s = bf.readLine();
			st = new StringTokenizer(s);
			s = st.nextToken();
			int index = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			for(int i=0;i<count;++i) {
				list.insertAfterNode(index, Integer.parseInt(st.nextToken()));
				index = index+2;
			}
		}
		list.printList();
		
	}

}
