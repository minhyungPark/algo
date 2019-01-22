
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
         
        for(int t=1;t<=T;++t) {
            int ans = Integer.parseInt(in.readLine());
            String s = in.readLine();
            Stack stack = new Stack();
            boolean result = true;
            for(int i=0;i<s.length();++i) {
                switch (s.charAt(i)) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '<':
                    stack.push('>');
                    break;
                case ')':case'}':case']':case'>':
                	if(stack.empty()) {
                		result = false;
                		break;
                	}else if((char) stack.pop()!=s.charAt(i))result = false;
                    break;
                default:
                    break;
                }
                if(!result)break;
            }
            if(result&&stack.empty())result=true;
            System.out.println(result?("#"+t+" 1"):("#"+t+" 0"));           
        }//test case
    }
}