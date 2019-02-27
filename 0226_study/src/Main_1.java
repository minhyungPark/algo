import java.util.Scanner;

public class Main_1 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] result = new int[12];
		result[1] = 1;
		result[2] = 2;
		result[3] = 4;
		for(int t=1;t<=T;++t) {
			N = sc.nextInt();
			for(int i=4;i<=N;++i) {
				if(result[i]==0) {
					result[i] = result[i-1]+result[i-2]+result[i-3];
				}
			}
			System.out.println(result[N]);
		}

	}

}
