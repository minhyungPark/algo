import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int N;
    static final long r = 31;
    static final long M = 1234567891;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[] c = sc.next().toCharArray();
        long[] pow = new long[N];
        powCal(pow, 0);
        long res = 0L;
        for(int i=0;i<N;++i){
            res += ((c[i]-'a'+1)*pow[i])%M;
            res%=M;
        }
        System.out.println(res);
    }
    private static void powCal(long[] pow,int depth){
        if(depth==N)return;
        if(depth==0)pow[depth] = 1;
        else {
            pow[depth] = (pow[depth-1]*r)%M;
        }
        powCal(pow,depth+1);
    }
}

