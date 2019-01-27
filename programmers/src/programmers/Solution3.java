package programmers;


public class Solution3 {

	static int N;
	static boolean[][] check;
	static int cnt;

	private static class Pair{
		int i,j;
		Pair(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	public static int solution(int[][] board, int[] nums) {
        int answer = 0;
        N = board.length;
        check = new boolean[N][N];
        
        for(int n=0;n<nums.length;++n) {
OUTER:     	for(int i=0;i<N;++i) {
        		for(int j=0;j<N;++j) {
        			if(nums[n]==board[i][j]) {
        				check[i][j]=true;
        				break OUTER;
        			}
        		}
        	}
        }
        if(check[0][0]) {
        	cnt = 1;
        	dfs(new Pair(0,0),1,1);
        	if(cnt==N)answer++;
        	cnt = 1;
        	dfs(new Pair(0,0),0,1);
        	if(cnt==N)answer++;
        	cnt = 1;
        	dfs(new Pair(0,0),1,0);
        	if(cnt==N)answer++;
        }
        for(int j=1;j<N-1;++j) {
        	if(check[0][j]) {
        		cnt = 1;
        		dfs(new Pair(0,j),1,0);
        		if(cnt==N)answer++;
        	}
        }
        if(check[0][N-1]) {
        	cnt = 1;
        	dfs(new Pair(0,N-1),1,-1);
        	if(cnt==N)answer++;
        	cnt = 1;
        	dfs(new Pair(0,N-1),1,0);
        	if(cnt==N)answer++;
        }
        for(int i=1;i<N;++i) {
        	if(check[i][0]) {
        		cnt = 1;
        		dfs(new Pair(i,0),0,1);
        		if(cnt==N)answer++;
        	}
        }
               
        
        return answer;
    }
	
	
	private static void dfs(Pair pair, int i, int j) {
		int nextX;
		int nextY;
		nextX = pair.i+i;
		nextY = pair.j+j;
		if(nextX<0||nextX>=N||nextY<0||nextY>=N) {
			return;
		}
		if(check[nextX][nextY]) {
			cnt++;
			dfs(new Pair(nextX,nextY),i,j);
		}
		
	}


	public static void main(String[] args) {
		int[][] b = {{11,13,15,16},{12,1,4,3},{10,2,7,8},{5,14,6,9}};
		int[] n = {14,3,2,4,13,1,16,11,5,15};
		
		System.out.println(solution(b,n));
	}

}
