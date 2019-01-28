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
	}
	private static class Linked{
		Node head;
		Node tail;
		public Linked() {}
		public void addLastNode(int data) {
			Node newNode = new Node(data);
			if(tail == null) {
				head = newNode;
				tail = newNode;
			}else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		public static void linkLinked(Linked origin,int index,Linked list) {
			if(index == 0) {
				Node temp = origin.head;
				origin.head = list.head;
				list.tail.next = temp;
			}else {
				Node currNode = origin.head;
				for(int i=1;i<index;++i) {
					currNode = currNode.next;
				}
				Node temp = currNode.next;
				currNode.next = list.head;
				list.tail.next = temp;
			}
			
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
				Linked tempList = new Linked();
				for(int i=0;i<count;++i) {
					tempList.addLastNode(Integer.parseInt(st.nextToken()));
				}
				Linked.linkLinked(list, index, tempList);
			}
			System.out.print("#"+t+" ");
			list.printList();
		}
	}
}
