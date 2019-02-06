import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178_미로탐색 {

    private static class Pair{
        int x,y,cnt;

        Pair(int x,int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] check;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N][M];
        char[] ans;
        for(int i=0;i<N;++i){
            ans = bf.readLine().toCharArray();
            for(int j=0;j<M;++j){
                if(ans[j]=='0'){
                    check[i][j]=true;
                }
            }
        }
        Queue<Pair> que = new LinkedList<>();
        check[0][0] = true;
        que.add(new Pair(0,0,1));
        while(!que.isEmpty()){
            Pair p = que.poll();
            if(p.x==N-1&&p.y==M-1) {
            	System.out.println(p.cnt);
            	break;
            }
            for(int i=0;i<4;++i){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if(nextX<0||nextX>=N||nextY<0||nextY>=M){
                    continue;
                }
                if(!check[nextX][nextY]){
                    check[nextX][nextY]=true;
                    que.add(new Pair(nextX,nextY,p.cnt+1));
                }
            }
        }
    }
}
