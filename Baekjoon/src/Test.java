import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		for(int i=1;i<=N;++i) {
			for(int j=i;j<N;++j) {
				sb.append(" ");
			}
			for(int j=0;j<i;++j) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
    }
}
