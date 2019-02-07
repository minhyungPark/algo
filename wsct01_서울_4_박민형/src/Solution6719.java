import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6719 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input6719.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<N;++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			double result = 0.0;
			Arrays.sort(arr);
			int[] number = Arrays.copyOfRange(arr, N-K, N);
			for(int i=0;i<K;++i) {
				result = (result+number[i])/2.0;
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
