import java.util.Scanner;
 
public class Solution3752_시험{
 
    static int N;
    static int[] num;
    static boolean[][] visited;
    static int[] index;
    static int result;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;++t) {
            N = sc.nextInt();
            result = 0;
            num = new int[N];
            count = 0;
            int sum = 0;
            for(int i=0;i<N;++i) {
                num[i] = sc.nextInt();
                sum +=num[i];
            }
            index = new int[sum+1];
            index[0] = 1;
            for(int i=0;i<N;++i) {
            	int temp = num[i];
            	for(int j=sum;j>=temp;--j) {
            		if(index[j-temp]==1) {
            			index[j]=1;
            		}
            	}
            }
            for(int i=0;i<index.length;++i) {
            	if(index[i]!=0)result++;
            }
            
             
            System.out.println("#"+t+" "+result);
        }
    }
}