import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1213_string {

	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("test_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;++t) {
			String temp = bf.readLine();
			String target = bf.readLine();
			String s = bf.readLine();
			int result = 0;
			for(int i=0;i<s.length()-target.length()+1;++i) {
				if(s.substring(i, target.length()+i).equals(target)) {
					result++;
				}
			}
			System.out.println("#"+t+" "+result);
			
		}
	}

}
