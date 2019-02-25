import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1256_k번째접미어 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			int k = Integer.parseInt(bf.readLine());
			
			String st = bf.readLine();
			int len = st.length();
			if(k>len) {
				System.out.println("#"+t+" none");
				continue;
			}
			String[] stArr = new String[len];
			for(int i=0;i<len;++i) {
				stArr[i] = st.substring(i, len);
			}
			Arrays.sort(stArr);
			
			System.out.println("#"+t+" "+stArr[k-1]);
			
		}
		
	}

}
