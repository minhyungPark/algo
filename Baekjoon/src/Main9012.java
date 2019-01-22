import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			char[] c = bf.readLine().toCharArray();
			boolean result = true;
			int cnt=0;
			for(int i=0;i<c.length;++i) {
				if(cnt<0) {
					result = false;
					break;
				}else {
					if(c[i]=='(')
						cnt++;
					else
						cnt--;
				}
			}
			if(cnt<0) {
				System.out.println("NO");
			}else
				System.out.println("YES");
//			System.out.println(result?"Yes":"No");
		}
	}
}
