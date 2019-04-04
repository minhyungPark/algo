import java.util.Scanner;
 
public class Test {
 
    static int[][] bc;
    static int N = 10;
    static int[] aT,bT;
    static int[] a,b;
    static int M,A;
    static int[] dx = {0,0,1,0,-1};
    static int[] dy = {0,-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1;t<=T;++t) {
            M = sc.nextInt();
            A = sc.nextInt();
            int[][] map = new int[N][N];
            a = new int[2];
            b = new int[2];
            a[0]=0;a[1]=0;
            b[0]=9;b[1]=9;
            aT= new int[M+1];
            bT= new int[M+1];
            bc = new int[A+1][4];
            for(int k=0;k<2;++k) {
                for(int i=1;i<=M;++i) {
                    if(k==0)aT[i]=sc.nextInt();
                    else bT[i]=sc.nextInt();
                }
            }
            
            for(int i=1;i<=A;++i) {
                bc[i][0] = (sc.nextInt()-1);
                bc[i][1] = (sc.nextInt()-1);
                bc[i][2] = sc.nextInt();
                bc[i][3] = sc.nextInt();
            }//입력끝
            color(map);	// 새로운 맵을 만든다. bc의 영향이 미치는 곳에
            int result = 0;
            for(int i=0;i<=M;++i) {
                result+= move(map,aT[i],bT[i],a,b);
            }
            System.out.println("#"+t+" "+result);
        }
        sc.close();
    }
     
    private static int move(int[][] map, int aDir, int bDir, int[] a, int[] b) {
        int ax = a[0];int ay = a[1];
        int bx = b[0];int by = b[1];
        int nax = ax+dx[aDir];
        int nay = ay+dy[aDir];
        int nbx = bx+dx[bDir];
        int nby = by+dy[bDir];
        int aN = map[nax][nay];
        int bN = map[nbx][nby];
        a[0] = nax;
        a[1] = nay;
        b[0] = nbx;
        b[1] = nby;
        if(aN==0&&bN==0)return 0;
        if(aN!=0&&bN==0) {
            int[] temp = find(aN);
            int max = 0;
            for(int i=0;i<temp.length;++i) {
                max=max<bc[temp[i]][3]?bc[temp[i]][3]:max;
            }
            return max;
        }
        if(aN==0&&bN!=0) {
            int[] temp = find(bN);
            int max = 0;
            for(int i=0;i<temp.length;++i) {
                max=max<bc[temp[i]][3]?bc[temp[i]][3]:max;
            }
            return max;
        }
        if(aN!=0&&bN!=0) {
            int[] t1 = find(aN);
            int[] t2 = find(bN);
            int max = 0;
            for(int i=0;i<t1.length;++i) {
                for(int j=0;j<t2.length;++j) {
                    if(t1[i]==t2[j]) {
                        int temp = bc[t1[i]][3];
                        max = max<temp?temp:max;
                    }else {
                        int temp = bc[t1[i]][3]+bc[t2[j]][3];
                        max = max<temp?temp:max;
                    }
                }
            }
            return max;
        }
        return 0;
    }
 
    private static int[] find(int aN) {
        int size = (aN+"").length();
        int[] temp = new int[size];
        int index = 0;
        while(aN!=0) {
            temp[index++] = aN%10;
            aN/=10;
        }       
        return temp;
    }
 
    private static void color(int[][] map) {
        for(int i=0;i<N;++i) {
            for(int j=0;j<N;++j) {
                for(int b=1;b<=A;++b) {
                    int x = bc[b][0];
                    int y = bc[b][1];
                    int w = bc[b][2];
                    if(Math.abs(i-x)+Math.abs(j-y)<=w) {
                        map[i][j]=map[i][j]*10+b;
                    }
                }
            }
        }
    }
}