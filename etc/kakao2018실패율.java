import java.util.Arrays;
import java.util.Comparator;

class Solution {
    
    private static class Node {
        int num;
        double rate;
        Node(int num, double rate) {
            this.num = num;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", rate=" + rate +
                    '}';
        }
    }

    public int[] solution(int N, int[] stages) {
        double[] dodal = new double[N+2];
        double[] notClear = new double[N+2];
        for(int s : stages) {
            for(int i=1;i<=s;++i) {
                dodal[i]++;
            }
            notClear[s]++;
        }
        Node[] nodes = new Node[N];
        for(int i=0;i<N;++i) {
            if(dodal[i+1] == 0.0) nodes[i] = new Node(i+1,0);
            else nodes[i] = new Node(i+1,notClear[i+1]/dodal[i+1]);
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.rate == o2.rate) {
                    return o1.num - o2.num;
                }
                if(o2.rate > o1.rate) return 1;
                else return -1;
            }
        });
        Arrays.toString(nodes);
        int[] answer = new int[N];
        for(int i=0;i<N;++i) {
            answer[i] = nodes[i].num;
        }
        return answer;
    }
}
