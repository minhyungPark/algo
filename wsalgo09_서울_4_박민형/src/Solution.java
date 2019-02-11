import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<M;++i) {
				sb.append("0");
			}
			char[] c = null;
			for(int i=0;i<N;++i) {
				String s = bf.readLine();
				if(!s.equals(sb.toString())&&c==null) {
					c=s.toCharArray();
				}
			}
//			System.out.println(String.copyValueOf(c));
			int key=0;
			for(int i=c.length-1;i>=0;--i) {
				if(c[i]=='1') {
					key=i;
					break;
				}
			}
			key = key-56+1;
			int[] result= new int[8];
			int count=0;
			String[] num = {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
			for(int i=key;i<key+56;i+=7) {
				String s = String.copyValueOf(c, i, 7);
				for(int n=0;n<num.length;++n) {
					if(s.equals(num[n])) {
						result[count++] = n;
						System.out.println(n);
					}
				}
			}
			System.out.println(Arrays.toString(result));
			
			
		}
		
	}

}
