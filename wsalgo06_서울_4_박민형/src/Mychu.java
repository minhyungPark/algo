import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mychu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mychuCnt = sc.nextInt();
		int total = 0;
		int[] arr = new int[mychuCnt+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int i=1;
		int n;
		int result;
		while(true) {
			queue.offer(i++);
			n = queue.poll();
			total+=++arr[n];
			if(total>=mychuCnt) {
				result = n;
				break;
			}
			queue.offer(n);
		}
		System.out.println(result);
	}

}
