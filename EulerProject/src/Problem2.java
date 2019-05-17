
public class Problem2 {

	public static void main(String[] args) {
		int[] fibo = new int[10000];
		fibo[0] = 1;
		fibo[1] = 1;
		fibo[2] = 2;
		long ans = 0L;
		for(int i=2;i<10000;++i) {
			fibo[i] = fibo[i-1]+fibo[i-2];
			if(fibo[i]>=4000000)break;
			if(fibo[i]%2==0)ans+=fibo[i];
		}
		System.out.println(ans);
	}

}
