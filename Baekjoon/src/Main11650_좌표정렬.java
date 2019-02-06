import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main11650_좌표정렬 {

	private static class Pair{
		int x,y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st;	
		Pair[] p = new Pair[N];
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(bf.readLine());
			p[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(p, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.x>o2.x) {
					return 1;
				}else if(o1.x<o2.x) {
					return -1;
				}else{
					if(o1.y>o2.y)
						return 1;
					else
						return -1;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;++i) {
			sb.append(p[i].x);
			sb.append(' ');
			sb.append(p[i].y);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		

	}

}
