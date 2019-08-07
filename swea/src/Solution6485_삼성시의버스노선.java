import java.util.Scanner;

public class Solution6485_삼성시의버스노선 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb= new StringBuilder();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int[] index = new int[50001];
			for(int i=0;i<N;++i) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j=a;j<=b;++j) {
					index[j]++;
				}
			}
			int p = sc.nextInt();
			sb.append("#").append(t).append(" ");
			for(int i=0;i<p;++i) {
				sb.append(index[sc.nextInt()]).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString().trim());
	}

}
