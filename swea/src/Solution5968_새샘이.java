import java.util.Scanner;

public class Solution5968_새샘이 {

	static int[] prime;
	static int result;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		prime = new int[168];
		makePrime();
		/*for(int i=0;i<168;++i) {
			System.out.print(prime[i]+",");
		}*/
		int T = sc.nextInt();
		for(int t=1;t<=T;++t) {
			int N = sc.nextInt();
			result = 0;
			dfs(N,0,0);
			System.out.println("#"+t+" "+result);
		}
	}
	private static void dfs(int N,int depth,int index) {
		if(depth==3) {
			if(N==0) result++;
			return;
		}
		// 이미 0보다 작아지면 return
		if(N<=0)return;
		
		for(int i=0;i<168;++i) {
			// x<=y<=z 조건
			if(i>=index) {
				if(N-prime[i]<0)break;
				dfs(N-prime[i],depth+1,i);
			}
		}
	}
	
	private static void makePrime() {
		int cnt=0;
		for(int i=2;i<1000;++i) {
			for(int j=2;j<=i;++j) {
				if(i==j) {
					prime[cnt++] = i;
				}else if(i%j==0)break;
			}
			
		}
		
	}

}
