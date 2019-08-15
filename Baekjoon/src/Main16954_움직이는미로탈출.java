import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main16954_움직이는미로탈출 {

    static int N=8,M=8;
    static int[] dx = {0,0,-1,1,1,1,-1,-1,0};
    static int[] dy = {1,-1,0,0,1,-1,1,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[N][M];
        for(int i=0;i<N;++i){
            char[] tChar = sc.next().toCharArray();
            for(int j=0;j<M;++j){
                if(tChar[j]=='#')arr[i][j] = -1;
            }
        }
        int res = bfs(arr);
        System.out.println(res);
    }

    private static int bfs(int[][] arr) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][][] check = new boolean[N][M][64];
        int[] tt= {7,0,0};
        check[7][0][0] = true;
        que.offer(tt);
        while(!que.isEmpty()){

            int qs = que.size();
            for(int i=0;i<qs;++i){
                int[] c =  que.poll();
                int x = c[0];
                int y = c[1];
                int t = c[2];
                if(x==0||y==7)return 1;
                if(arr[x][y]==-1)continue;
                for(int d = 0;d<9;++d){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx<0||ny<0||nx>=N||ny>=M)continue;
                    if(arr[nx][ny]==-1||check[nx][ny][t+1])continue;
                    int[] temp = {nx,ny,t+1};
                    que.offer(temp);
                    check[nx][ny][t+1] = true;
                }
            }
            downArr(arr);
        }

        return 0;
    }

    private static void downArr(int[][] arr) {
        for(int j=0;j<M;++j){
            for(int i=7;i>0;--i){
                arr[i][j] = arr[i-1][j];
            }
            arr[0][j] = 0;
        }
    }


}
