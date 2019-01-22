import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Stack{
	
	int[] stackArr;
	int index;
	
	Stack(int N){
		stackArr = new int[N];
		index = -1;
	}
	
	public void push(int x) {
		stackArr[++index] = x;
	}

	public int top() {
		if(empty()==1)return -1;
		return stackArr[index];
	}
	public int pop() {
		if(empty()==1)return -1;
		return stackArr[index--];
	}
	public int empty() {
		if(index==-1)return 1;
		return 0;
	}
	public int size() {
		return index+1;
	}
	
}


public class Main10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		Stack stack = new Stack(T);
		
		for(int t=0;t<T;++t) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			s = st.nextToken();
			if(s.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(s.equals("pop")) {
				System.out.println(stack.pop());
			}else if(s.equals("size")) {
				System.out.println(stack.size());
			}else if(s.equals("empty")) {
				System.out.println(stack.empty());
			}else if(s.equals("top")) {
				System.out.println(stack.top());
			}
		}
		
	}

}
