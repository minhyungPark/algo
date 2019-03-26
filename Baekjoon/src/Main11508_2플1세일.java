import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main11508_2플1세일 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] milk = new int[N];
		for(int i=0;i<N;++i) {
			milk[i]=Integer.parseInt(bf.readLine());
		}
		Arrays.sort(milk);
		int[] temp = new int[N];
		for(int i=0;i<N;++i) {
			temp[i] = milk[N-1-i];
		}
		int result = 0;
		for(int i=0;i<N;++i) {
			if(i%3!=2) {
				result+=temp[i];
			}
		}
		System.out.println(result);
		
		
	}

}
