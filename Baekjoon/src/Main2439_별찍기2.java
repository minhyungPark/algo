import java.util.Scanner;

public class Main2439_별찍기2 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			printStar(i);
		}

	}
	private static void printStar(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i=n;i<N;++i) {
			sb.append(' ');
		}
		for(int i=0;i<n;++i) {
			sb.append('*');
		}
		System.out.println(sb.toString());
	}

}
