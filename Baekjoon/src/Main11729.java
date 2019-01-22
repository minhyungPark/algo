import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main11729 {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		bw.write(hanoicnt(N)+"\n");
		hanoi(N,1,2,3);
		bw.flush();
		bw.close();
	}

	private static int hanoicnt(int n) {
		if(n==1)return 1;
		return hanoicnt(n-1)*2+1;
	}

	private static void hanoi(int n, int now, int temp, int next) throws IOException {

		if(n==1) {
			bw.write(now+" "+next+"\n");
			return;
		}
		
		hanoi(n-1,now,next,temp);
		bw.write(now+" "+next+"\n");
		hanoi(n-1,temp,now,next);
	}

}
