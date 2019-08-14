import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406_배열돌리기4 {

    static int N,M,K;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][M+1];
        for(int i=1;i<=N;++i){
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=M;++j){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] cmd = new int[K][3];
        for(int i=0;i<K;++i){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<3;++j) {
                cmd[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] order = new int[K];
        int res = dfs(0,arr,cmd,order,0);
        System.out.println(res);
    }

    private static int dfs(int depth, int[][] arr, int[][] cmd,int[] order,int flag) {
        int res = Integer.MAX_VALUE;
        if(depth == K) {
            int[][] tArr = new int[N+1][M+1];
            arrClone(arr,tArr);
            return rotate(tArr,cmd,order);
        }
        for(int i=0;i<K;++i){
            if((flag&(1<<i))!=0) continue;
            order[depth] = i;
            int temp = dfs(depth+1,arr,cmd,order,flag | (1<<i));
            res = temp < res ? temp: res;
        }
        return res;
    }

    private static int rotate(int[][] arr, int[][] cmd, int[] order) {
        for(int i=0;i<K;++i){
            int[] tCmd = cmd[order[i]];
            int r = tCmd[0];
            int c = tCmd[1];
            int s = tCmd[2];
            goRotate(arr,r-s,c-s,2*s+1);
        }
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=N;++i){
            int temp = 0;
            for(int j=1;j<=M;++j){
                temp += arr[i][j];
            }
            res = temp<res?temp:res;
        }
        return res;
    }

    private static void goRotate(int[][] arr, int x, int y,int length) {

        if(length==0 || length==1)return;

        int temp = arr[x][y+length-1];
        for(int j=y+length-1;j>y;--j){
            arr[x][j] = arr[x][j-1];
        }
        int temp1 = arr[x+length-1][y+length-1];
        for(int i=x+length-1;i>x+1;--i){
            arr[i][y+length-1] = arr[i-1][y+length-1];
        }
        arr[x+1][y+length-1] = temp;
        temp =  arr[x+length-1][y];
        for(int j=y;j<y+length-2;++j){
            arr[x+length-1][j] = arr[x+length-1][j+1];
        }
        arr[x+length-1][y+length-2] = temp1;
        for(int i=x;i<x+length-2;++i){
            arr[i][y] = arr[i+1][y];
        }
        arr[x+length-2][y] = temp;
        goRotate(arr,x+1,y+1,length-2);
    }

    private static void arrClone(int[][] arr, int[][] tArr) {
        for(int i=1;i<=N;++i)for(int j=1;j<=M;++j)tArr[i][j] = arr[i][j];
    }
}

