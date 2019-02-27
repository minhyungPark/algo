import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] temperature = new int[N][2];
		int[] refri = new int[10000+270+1];

		Arrays.fill(refri, N);
		
		for(int i=0;i<N;++i) {
			temperature[i][0] = sc.nextInt();
			temperature[i][1] = sc.nextInt();
		}
		
		for(int i=0;i<N;++i) {
			int a = temperature[i][0]+270;
			int b = temperature[i][1]+270;
			for(int j=a;j<=b;++j) {
				refri[j]--;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<refri.length;++i) {
			if(refri[i]<min)min=refri[i];
		}
		System.out.println(min);
		
	}

}
