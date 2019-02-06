import java.util.Scanner;

public class Main11726_타일링 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==1) {
			System.out.println(1);
			return;
		}
		if(N==2) {
			System.out.println(2);
			return;
		}
		int[] sum=new int[N+1];
		sum[0]=1;
		sum[1]=1;
		for(int i=2;i<=N;++i) {
			sum[i] = (sum[i-1]+sum[i-2])%10007;
		}
		System.out.println(sum[N]);
	}

}
