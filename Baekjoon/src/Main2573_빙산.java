import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2573_빙산 {

    static int N,M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0;i<N;++i){
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<M;++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = go(map);
        System.out.println(res);

    }

    private static int go(int[][] map) {
        int res = 0;
        while(true){
            melt(map);
            res++;
            if(!isIce(map)){
                res = 0;
                break;
            }
            if(isTwo(map))break;
        }

        return res;
    }

    private static void melt(int[][] map) {
        int[][] tArr = new int[N][M];
        clone(map,tArr);
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j]!=0){
                    int diff = how(map,i,j);
                    tArr[i][j] -= diff;
                    if(tArr[i][j]<0)tArr[i][j] = 0;
                }
            }
        }
        clone(tArr,map);
    }

    private static int how(int[][] map,int x,int y) {
        int res = 0;
        for(int i=0;i<4;++i){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=N||ny>=M)continue;
            if(map[nx][ny]==0)res++;
        }
        return res;
    }

    private static boolean isTwo(int[][] map) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
outer:  for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j]!=0){
                    int[] temp = {i,j};
                    visited[i][j] = true;
                    que.offer(temp);
                    break outer;
                }
            }
        }

        while(!que.isEmpty()){
            int[] cur = que.poll();

            for(int i=0;i<4;++i){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;
                if(map[nx][ny]==0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                int[] temp = {nx,ny};
                que.offer(temp);
            }

        }

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j] != 0 && !visited[i][j])return true;
            }
        }
        return false;
    }

    private static boolean isIce(int[][] map) {
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j]!=0)return true;
            }
        }
        return false;
    }

    private static void clone(int[][] arr,int[][] target) {
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                target[i][j] = arr[i][j];
            }
        }

    }

}
