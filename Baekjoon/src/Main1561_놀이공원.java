import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1561_놀이공원 {

	static int N,M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for(int i=0;i<M;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(N<=M) {
			System.out.println(N);
			return;
		}
		
		
	}

}
