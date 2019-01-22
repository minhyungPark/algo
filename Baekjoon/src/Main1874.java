import java.util.Scanner;
import java.util.Stack;

public class Main1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] numbers = new int[N];
		for(int i=0;i<N;++i) {
			arr[i] = sc.nextInt();
			numbers[i] = i+1;
		}
		int n=0;
		int i=0;
		Stack<Integer> stack = new  Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
OUTER:	while(n<N) {
			while(i<N) {
				if(arr[n]==numbers[i]) {
					stack.push(numbers[i]);
					stack.pop();
					sb.append("+-");
					++n;
					++i;
				}else if(arr[n]>numbers[i]) {
					stack.push(numbers[i]);
					sb.append('+');
					++i;
				}else {
					if(stack.peek()>arr[n]) {
						flag = false;
						break OUTER;
					}
					else {
						stack.pop();
						sb.append('-');
						++n;
					}
				}
			}
			if(i==N) {
				while(!stack.isEmpty()) {
					if(stack.peek()>arr[n]) {
						flag=false;
						break OUTER;
					}else {
						stack.pop();
						sb.append('-');
						++n;
					}
				}
			}
		}
		if(flag) {
			char[] c = sb.toString().toCharArray();
			for(int j=0;j<c.length;++j) {
				System.out.println(c[j]);
			}
		}else {
			System.out.println("NO");
		}
		
	}

}
