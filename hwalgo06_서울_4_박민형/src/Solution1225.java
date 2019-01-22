import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1225 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Solution.txt"));
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;++t) {
			Queue<Integer> q = new LinkedList<Integer>();
			int ans = sc.nextInt();
			for(int i=0;i<8;++i) {
				q.offer(sc.nextInt());
			}
			int n;
OUTER:		while(true) {
				for(int i=1;i<=5;++i) {
					n=q.poll();
					n = n-i;
					if(n<=0) {
						q.offer(0);
						break OUTER;
					}
					q.offer(n);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t);
			for(int i=0;i<8;++i) {
				sb.append(" "+q.poll());
			}
			System.out.println(sb.toString());
		}
	}

}
