package programmers;

import java.util.Arrays;

public class Solution2 {

	public static int solution(int l, int[] v) {
        int answer = 0;

        Arrays.sort(v);
        int max = Integer.MIN_VALUE;
        int ans;
        for(int i=0;i<v.length-1;++i) {
        	ans = v[i+1]-v[i];
        	if(ans>max) max = ans;
        }
        if(v[0]-0>max) {
        	return v[0]-0;
//        	max = v[0]-0;
        }
        if(l-v[v.length-1]>max) {
        	return l-v[v.length-1];
//        	max = l-v[v.length-1];
        }
        
        if(max%2==0) {
        	answer = max/2;
        }else
        	answer = max/2 +1;

        return answer;
    }
	
	public static void main(String[] args) {
		int[] v = {15,5,3,7,9,14,0};
		int l = 15;
		System.out.println(solution(l,v));
		
		
	}

}
