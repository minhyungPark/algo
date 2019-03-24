import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1764 {

	static int count;
	static String[] list2;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		list2 = new String[M];
		list = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<N;++i) {
			String temp = bf.readLine();
			map.put(temp, temp);
		}
		for(int i=0;i<M;++i) {
			list2[i] = bf.readLine();
		}
		Arrays.sort(list2);
		for(int i=0;i<M;++i) {
			if(map.containsKey(list2[i])) {
				list.add(list2[i]);
			}
		}
		sb.append(list.size()).append("\n");
		for(int i=0;i<list.size();++i) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}
