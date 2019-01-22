import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main11728 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] narr = new int[N];
		int[] marr = new int[M];
		int[] arr = new int[N+M];
		
		for(int i=0;i<N;++i) {
			narr[i] = sc.nextInt();
		}
		for(int i=0;i<M;++i) {
			marr[i] = sc.nextInt();
		}
		for(int i=0;i<N+M;++i) {
			if(i<N)arr[i] = narr[i];
			else arr[i] = marr[i-N];
		}
		Arrays.sort(arr);
		for(int i=0;i<N+M;++i) {
			System.out.print(arr[i]+" ");
		}
	}
}
