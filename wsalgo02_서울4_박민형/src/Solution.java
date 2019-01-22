import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			BigInteger bit = BigInteger.ZERO;
			for(int k=0;k<K;++k) {
				int num = sc.nextInt();
				bit = bit.or(BigInteger.ONE.shiftLeft(num-1));
			}
			System.out.print("#"+t);
			for(int n = 1; n<=N;++n) {
				if(bit.and(BigInteger.ONE.shiftLeft(n-1)).equals(BigInteger.ZERO))System.out.print(" "+n);
			}
			System.out.println();
		}
	}
}
