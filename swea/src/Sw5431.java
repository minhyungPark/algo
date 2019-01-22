import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sw5431 {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] bit = new int[N+1];
			for(int k=0;k<K;++k) {
				int num = sc.nextInt();
				bit[num]++;
			}
			System.out.print("#"+t);
			for(int n = 1; n<=N;++n) {
				if(bit[n]==0)System.out.print(" "+n);
			}
			System.out.println();
		}
	}
}
