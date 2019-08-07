import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493_탑 {

    private static class Node{
        int height;
        int x;
        Node(int height,int x){
            this.height=height;
            this.x = x;
        }
    }

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr = new int[N];
        for(int i=0;i<N;++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(new Node(arr[0],0));
        sb.append(0+" ");
        for(int i=1;i<N;++i){
            while(true){
                if(stack.isEmpty()){
                    stack.push(new Node(arr[i],i));
                    sb.append("0 ");
                    break;
                }
                Node temp = stack.peek();
                if(temp.height<=arr[i]){
                    stack.pop();
                    continue;
                }else{
                    stack.push(new Node(arr[i],i));
                    sb.append(temp.x+1).append(" ");
                    break;
                }

            }
        }
        System.out.println(sb.toString().trim());
    }
}
