import java.util.Scanner;

public class Main16953_AB {

	static long A,B;
	static int result;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		dfs(0,A);
		System.out.println(result!=0?result:-1);
	}
	private static void dfs(int depth,long num) {
		if(num==B) {
			if(result==0)result = depth+1;
			else if(result>depth+1)result = depth+1;
			return;
		}
		if(num>B) {
			return;
		}
		dfs(depth+1,num*10+1);
		dfs(depth+1,num*2);
	}

}
