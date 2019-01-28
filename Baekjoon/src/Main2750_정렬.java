import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2750_정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		for(int i=0;i<N;++i) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		int min=Integer.MAX_VALUE;
		int key;
		for(int i=0;i<N;++i) {
			min = Integer.MAX_VALUE;
			key = 0;
			for(int j=i;j<N;++j) {
				if(arr[j]<min) {
					min = arr[j];
					key = j;
				}
			}
			int temp = arr[key];
			arr[key] =arr[i];
			arr[i] = temp;
		}
		for (int i : arr) {
			System.out.println(i);
		}
		
	}

}
