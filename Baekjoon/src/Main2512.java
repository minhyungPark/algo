import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2512 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int sum = Integer.parseInt(bf.readLine());
		int result = 0;
		Arrays.sort(arr);
		int i=0;
		int size = arr.length;
		while(i<arr.length&&(sum/size)>arr[i]) {
			sum-=arr[i++];
			--size;
		}
		if(i==arr.length) {
			result = arr[arr.length-1];
		}else {
			result = sum/size;
		}
		System.out.println(result);
	}

}
