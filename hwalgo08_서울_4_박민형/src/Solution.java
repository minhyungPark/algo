import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			int N = Integer.parseInt(bf.readLine());
			char[] tree = new char[N+1];
			for(int i=1;i<N+1;++i) {
				String s = bf.readLine();
				StringTokenizer st = new StringTokenizer(s);
				st.nextToken();
				tree[i] = st.nextToken().charAt(0);
			}
			boolean flag = true;
			for(int i=1;i<=N;++i) {
				if(i<=N/2) {
					if(tree[i]!='*'&&tree[i]!='/'&&tree[i]!='+'&&tree[i]!='-') {
						flag = false;
						break;
					}
				}else {
					if(tree[i]=='*'||tree[i]=='/'||tree[i]=='+'||tree[i]=='-') {
						flag = false;
						break;
					}
					
				}
			}
			System.out.println(flag ? ("#"+t+" 1"):("#"+t+" 0"));
		}
	}
}
