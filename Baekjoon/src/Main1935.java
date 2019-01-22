import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1935 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		char[] c = bf.readLine().toCharArray();
		double[] numbers = new double[N];
		
		for(int i=0;i<N;++i) {
			numbers[i] = Double.parseDouble(bf.readLine());
		}
		Stack<Double> stack = new Stack<>();
		double result = 0.0;
		double b,a;
		for(int i=0;i<c.length;++i) {
			switch (c[i]) {
			case '*':
				b = stack.pop();
				a = stack.pop();
				result = a*b;
				stack.push(result);
				break;
			case '+':
				b = stack.pop();
				a = stack.pop();
				result = a+b;
				stack.push(result);
				break;
			case '-':
				b = stack.pop();
				a = stack.pop();
				result = a-b;
				stack.push(result);
				break;
			case '/':
				b = stack.pop();
				a = stack.pop();
				result = a/b;
				stack.push(result);
				break;
			default:
				stack.push(numbers[c[i]-'A']);
				break;
			}
			
		}
		System.out.printf("%.2f\n",result);
		
	}

}
