import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N+M];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;++i) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;++i) {
			arr[i+N] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N+M;++i) {
			sb.append(arr[i]);
			sb.append(' ');
		}
		System.out.println(sb.toString());
	}
}
