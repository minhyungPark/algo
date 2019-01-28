import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static class Node{
		int data;
		Node next;

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
		public Linked() {}
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
		public void addLastNode(int data) {
			Node lastNode = getLastNode();
			Node newNode = new Node(data);
			
			if(lastNode == null) {
				head = newNode;
			}else {
				lastNode.next = newNode;
			}
		}
		public void addFirstNode(int data) {
			Node newNode = new Node(data,head);
			head = newNode;
		}
		public void insertAfterNode(int index,int data) {
			if(index == 0) {
				addFirstNode(data);
				return;
			}
			Node currNode = head;
			Node newNode = new Node(data);
			int i=1;
			while(i<index) {
				currNode = currNode.next;
				++i;
			}
			Node temp = currNode.next;
			currNode.next = newNode;
			newNode.next = temp;
		}
		public void printList() {
			Node currNode = head;
			for(int i=0;i<10;++i) {
				System.out.print(currNode.data+" ");
				currNode = currNode.next;
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			Linked list = new Linked();
			int N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int n=0;n<N;++n) {
				list.addLastNode(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(bf.readLine());
			String s = bf.readLine();
			st = new StringTokenizer(s);
			for(int n=0;n<N;++n) {
				s = st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				for(int i=0;i<count;++i) {
					list.insertAfterNode(index++, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#"+t+" ");
			list.printList();
		}
	}
}
