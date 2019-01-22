import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5432_박민형 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        boolean[] laser = new boolean[s.length()];
        
        for(int i=0;i<s.length()-1;++i) {
        	if(s.charAt(i)=='('&&s.charAt(i+1)==')')laser[i] = true;
        }
        int cnt=0;
        int sum=0;
        for(int i=0;i<s.length();++i) {
        	if(laser[i]) {
        		sum+=cnt;
        		++i;
        	}else if(s.charAt(i)=='(') {
        		++cnt;
        	}else if(s.charAt(i)==')') {
        		++sum;
        		--cnt;
        	}
        }
        System.out.println(sum);
    }
}