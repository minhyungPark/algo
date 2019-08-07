import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16946_벽부수고이동하기4 {

    static int N,M;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static ArrayList<Integer> countList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i=0;i<N;++i){
            char[] c = bf.readLine().toCharArray();
            for(int j=0;j<M;++j){
                map[i][j] = c[j] - '0';
            }
        }

        int[][] res = go(map);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                sb.append(res[i][j]%10);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());

    }

    private static int[][] go(int[][] map) {
        int[][] res = count(map);
        return res;
    }

    private static int[][] count(int[][] map) {
        boolean[][] visited = new boolean[N][M];
        int[][] countArr = new int[N][M];
        int[][] res = new int[N][M];
        int index = 2;
        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(!visited[i][j] && map[i][j]==0){
                    bfs(i,j,visited,countArr,map,index);
                    index++;
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<N;++i){
            for(int j=0;j<M;++j){
                if(map[i][j] == 1){
                    int ans = 1;
                    set.clear();
                    for(int d=0;d<4;++d){
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if(nx<0||ny<0||nx>=N||ny>=M)continue;
                        if(countArr[nx][ny] == 0)continue;
                        if(set.contains(countArr[nx][ny]))continue;
                        set.add(countArr[nx][ny]);
                        ans += countList.get(countArr[nx][ny]-2);
                    }
                    res[i][j] = ans;
                }
            }
        }
        return res;
    }

    private static void bfs(int x, int y, boolean[][] visited, int[][] countArr,int[][] map,int index) {
        Queue<int[]> que = new LinkedList<>();
        int[] t = {x,y};
        int count = 0;
        visited[x][y] = true;
        ArrayList<int[]> list = new ArrayList<>();
        que.offer(t);
        list.add(t);
        while (!que.isEmpty()){
            count++;
            int[] c = que.poll();
            for(int i=0;i<4;++i) {
                int nx = c[0] + dx[i];
                int ny = c[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] || map[nx][ny] != 0) continue;
                int[] temp = {nx, ny};
                visited[nx][ny] = true;
                que.offer(temp);
                list.add(temp);
            }
        }
        for (int[] c: list) {
            countArr[c[0]][c[1]] = index;
        }
        countList.add(count);
    }
}
