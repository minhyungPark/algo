import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1918 {

	public static String toPostFix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] chars = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		final int SIZE = chars.length;
		char temp;
		for(int i=0;i<SIZE;++i) {
			temp = chars[i];
			switch (temp) {
			case ')':
				while(stack.peek()!='(') {
					postfix.append(stack.pop());
				}
				stack.pop();
				break;
			case '(':case '*':case '/':case '+':case '-':
				if(stack.isEmpty()) {
					stack.push(temp);
				}else {
					if(getPriority(temp,false)>getPriority(stack.peek(), true)) {
						stack.push(temp);
					}else {
						while(!stack.isEmpty()&&getPriority(temp,false)<=getPriority(stack.peek(), true)) {
							postfix.append(stack.pop());
						}
						stack.push(temp);
					}
				}
				break;
			default:
				postfix.append(temp);
				break;
			}
		}
		while(!stack.isEmpty())postfix.append(stack.pop());
		return postfix.toString();
	}
	
	public static int getPriority(char c,boolean b) {
		int p=0;
		switch (c) {
		case '(':
			if(b)p=0;
			else p=3;
			break;
		case '*':case '/':
			p=2;
			break;
		case '+':case '-':
			p=1;
			break;
		default:
			break;
		}
		return p;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(toPostFix(bf.readLine()));
	}

}
