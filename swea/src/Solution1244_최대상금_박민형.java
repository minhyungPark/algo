import java.util.Scanner;

public class Solution1244_최대상금_박민형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	}

}
/*import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int t=1;t<=T;++t) {
            String a = sc.next();
            int index;
            int n=0;
            index = a.indexOf('1');
            char[]s = a.toCharArray();
            int j=0;
            if(index==-1) {
                System.out.println("#"+t+" "+n);
            }else {
                n++;
                while(j!=s.length) {
                    for(j=index+1;j<s.length;++j) {
                        if(s[index]!=s[j]) {
                            ++n;
                            index=j;
                            break;
                        }
                    }
                }
                System.out.println("#"+t+" "+n);
            }
        }
    }
}*/