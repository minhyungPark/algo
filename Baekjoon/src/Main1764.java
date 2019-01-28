import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String>[] list = new ArrayList[26];
		for(int i=0;i<26;++i) {
			list[i] = new ArrayList<String>();
		}
		String s;
		for(int i=0;i<N;++i) {
			s = bf.readLine();
			int index = s.charAt(0) - 'a';
			list[index].add(s);
		}
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<M;++i) {
			s = bf.readLine();
			int index = s.charAt(0)-'a';
			for(int j=0;j<list[index].size();++j) {
				if(list[index].get(j).equals(s)) {
					result.add(s);
					break;
				}
			}
		}
		System.out.println(result.size());
		for (String string : result) {
			System.out.println(string);
		}

	}

}
