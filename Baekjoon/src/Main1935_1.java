import java.util.Scanner;

class Stack1{
	private int index;
	private double[] stackArr; 
	
	public Stack1(int N) {
		stackArr = new double[N];
		index = -1;
	}
	
	public void push(double n) {
		stackArr[++index] = n;
	}
	public double pop() {
		return stackArr[index--];
	}
	
}


public class Main1935_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] numbers = new double[N];
		String s = sc.next();
		char[] c = s.toCharArray();
		for(int i=0;i<N;++i) {
			numbers[i] = sc.nextDouble();
		}
		Stack1 stack = new Stack1(c.length);
		double a,b;
		for(int i=0;i<c.length;++i) {
			switch (c[i]) {
			case '+':
				b = stack.pop();
				a = stack.pop();
				stack.push(a+b);
				break;
			case '-':
				b = stack.pop();
				a = stack.pop();
				stack.push(a-b);
				
				break;
			case '*':
				b = stack.pop();
				a = stack.pop();
				stack.push(a*b);
				
				break;
			case '/':
				b = stack.pop();
				a = stack.pop();
				stack.push(a/b);
				break;

			default:
				stack.push(numbers[c[i]-'A']);
				break;
			}
			
		}
		System.out.printf("%.2f",stack.pop());
		
	}

}
