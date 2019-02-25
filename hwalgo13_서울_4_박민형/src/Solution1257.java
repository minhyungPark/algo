import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Solution1257 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t=1;t<=T;++t) {
			int k = Integer.parseInt(bf.readLine());
			String s = bf.readLine();
			int len = s.length();
			String[] stArr = new String[len];
			for(int i=0;i<len;++i) {
				stArr[i] = s.substring(i, len);
			}
			Arrays.sort(stArr);
			LinkedHashSet<String> list = new LinkedHashSet<String>();
			for(int i=0;i<len;++i) {
				for(int j=1;j<=stArr[i].length();++j) {
					list.add(stArr[i].substring(0,j));
				}
			}
			if(list.size()<k) {
				System.out.println("#"+t+" none");
				continue;
			}else {
				Iterator<String> it = list.iterator();
				for(int i=0;i<k-1;++i) {
					it.next();
				}
				System.out.println("#"+t+" "+it.next());
			}
		}
	}
}
