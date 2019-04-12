
public class Test {

	public static void main(String[] args) {
		LinkedStack st = new LinkedStack();
		System.out.println(st.size());
		st.push("A");
		st.push("B");
		st.push("C");
		st.push("D");
		st.push("E");
		st.push("F");
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

}
