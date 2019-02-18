import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007_패턴마디의길이 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			String s = bf.readLine();
			char[] c = s.toCharArray();
			int result = 0;
			for(int i=1;i<=10;++i) {
				String st = String.copyValueOf(c, 0, i);
				if(st.equals(String.valueOf(c,i,i))) {
					result = st.length();
					break;
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
		
	}

}
