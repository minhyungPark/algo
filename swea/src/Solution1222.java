
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1222 {

	// 중위 표현식 ==> 후위 표현식으로 변환
	public static String toPostFix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] chars = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		final int SIZE = chars.length;
		char temp;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			if(Character.isDigit(temp)) {
				postfix.append(temp);
			}else if(stack.isEmpty()) {
				stack.push(temp);
			}else {
				postfix.append(stack.pop());
				stack.push(temp);
			}
		}
		if(!stack.isEmpty())postfix.append(stack.pop());
		return postfix.toString();
	}
	private static int calculate(String postfix) {
		Stack<Integer> stack = new Stack<Integer>();
		char[] chars = postfix.toCharArray();
		final int SIZE = chars.length;
		char temp;
		int value1,value2;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			if(Character.isDigit(temp)) {
				int d = temp-'0';
				stack.push(d);
			}else {
				value2 = stack.pop();
				value1 = stack.pop();
				switch (temp) {
				case '+':
					stack.push(value1+value2);
					break;
				case '-':
					stack.push(value1-value2);
					break;
				case '*':
					stack.push(value1*value2);
					break;
				case '/':
					stack.push(value1/value2);
					break;
					
				default:
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("Solution1222.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t=1;t<=T;++t) {
			int n = Integer.parseInt(bf.readLine());
			String s = toPostFix(bf.readLine());
			System.out.println("#"+t+" "+calculate(s));
		}
	}

}
