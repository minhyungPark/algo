import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] students = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;++i) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(bf.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long ans = N;
		for(int i=0;i<N;++i) {
			students[i]-=B;
		}
		for(int i=0;i<N;++i) {
			if(students[i]>0) {
				if(students[i]%C==0) {
					ans+=students[i]/C;
				}else {
					ans+=(students[i]/C+1);
				}
			}
		}
		System.out.println(ans);
		

	}

}
