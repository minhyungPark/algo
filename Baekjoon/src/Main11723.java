import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String s;
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		for(int n=0;n<N;++n) {
			s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int i;
			switch (st.nextToken()) {
			case "add":
				i = Integer.parseInt(st.nextToken());
				flag = flag|(1<<i);
				break;
			case "remove":
				i = Integer.parseInt(st.nextToken());
				if((flag&(1<<i))!=0) {
					flag = flag^(1<<i);
				}
				break;
			case "check":
				i = Integer.parseInt(st.nextToken());
				if((flag&(1<<i))!=0) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				i = Integer.parseInt(st.nextToken());
				flag = flag^(1<<i);
				break;
			case "all":
				flag = (1<<21)-1;
				flag = flag&~(1);
				break;
			case "empty":
				flag = 0;
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
