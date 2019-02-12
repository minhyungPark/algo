import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1247 {

	private static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
 
    static int N;
    static Node company;
    static Node home;
    static Node[] nodes;
    static Node[] path;
    static boolean[] check;
    static int minValue;
     
    public static void main(String[] args) throws IOException {
    	System.setIn(new FileInputStream("input1247.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int t=1;t<=T;++t) {
            N = Integer.parseInt(bf.readLine());
            check = new boolean[N];
            nodes = new Node[N];
            path = new Node[N+2];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            company = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            home = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int i=0;i<N;++i) {
                nodes[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            path[0] = company;
            path[N+1] = home;
            minValue = Integer.MAX_VALUE;
            permutation(0);
            System.out.println("#"+t+" "+minValue);
        }
    }
 
    private static void permutation(int index) {
            if(index == N) {
                int temp =0;
            for(int i=0;i<path.length-1;++i) {
                temp += Math.abs(path[i].x-path[i+1].x)+Math.abs(path[i].y-path[i+1].y);
            }
            if(temp<minValue)
                minValue = temp;
            return;
        }
         
        for(int i=0;i<N;++i) {
            if(!check[i]) {
                check[i] = true;
                path[index+1] = nodes[i];
                permutation(index+1);
                check[i] = false;
            }
        }
    }
}
