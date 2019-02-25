import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1764 {

	static int count;
	static String[] list1;
	static String[] list2;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		list1 = new String[N];
		list2 = new String[M];
		list = new ArrayList<String>();
		for(int i=0;i<N;++i) {
			list1[i] = bf.readLine();
		}
		for(int i=0;i<M;++i) {
			list2[i] = bf.readLine();
		}
		Arrays.sort(list1);
		Arrays.sort(list2);

		for(int i=0;i<N;++i) {
			binarySearch(list1[i],0,M);
		}
		sb.append(list.size()).append("\n");
		for(int i=0;i<list.size();++i) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString().trim());
		
	}

	private static void binarySearch(String string, int start, int end) {
		if(start>end) {
			return;
		}
		
		int mid = (start+end)/2;
		if(list2[mid].equals(string)) {
			list.add(string);
		}else if(string.compareTo(list2[mid])>0) {
			binarySearch(string,mid+1,end);
		}else if(string.compareTo(list2[mid])<0) {
			binarySearch(string,start,mid-1);
		}
		
	}

}
