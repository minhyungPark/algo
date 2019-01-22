import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2747 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int result = Fibonacci(N);
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

	private static int Fibonacci(int n) {
		if(n==0) return 0;
		if(n==2||n==1)return 1;
		
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
}
