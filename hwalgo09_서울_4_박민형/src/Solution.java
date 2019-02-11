import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String numString = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			char[] c = numString.toCharArray();
			int[] number = new int[c.length];
			int[] index = new int[10];
			for(int i=0;i<c.length;++i) {
				number[i] = c[i]-'0';
				index[number[i]]++;
			}
			System.out.println();
			
		}

	}

}
