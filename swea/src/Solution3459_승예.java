import java.util.Scanner;

public class Solution3459_승예 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		long[] index = new long[63];
		for(int i=1;i<=62;++i) {
			index[i] = (makeNum(0,i));
		}
		int T= sc.nextInt();
		for(int t=1;t<=T;++t) {
			long N = sc.nextLong();
			int key = 0;
			for(int i=0;i<index.length;++i) {
				if(N>=index[i]) {
					key = i;
				}
			}
			if(key%2==0) {
				System.out.println("#"+t+" Bob");
			}else {
				System.out.println("#"+t+" Alice");
			}
		}
	}
	private static long makeNum(int depth,int n) {
		if(depth==n) {
			return 1;
		}
		if(depth%2==0) {
			return 2*makeNum(depth+1,n);
		}else {
			return 2*makeNum(depth+1,n)+1;
		}
	}
}
