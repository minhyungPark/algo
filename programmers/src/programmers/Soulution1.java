package programmers;

import java.util.Arrays;

public class Soulution1 {

	 public static boolean solution(int[] arrA, int[] arrB) {
	        boolean answer = true;
	        
	        int index=0;;
	        for(int i=0;i<arrB.length;++i) {
	        	if(arrA[0]==arrB[i]) {
	        		index = i;
	        		break;
	        	}
	        }
	        if(index==0) {
	        	boolean flag = true;
	        	int j=0;
	        	while(flag&&j<arrA.length) {
        			if(arrA[j]!=arrB[j])flag = false;
        			++j;
	        	}
	        	if(!flag)return flag;
	        }
	        
	        int[] before = Arrays.copyOfRange(arrB, index, arrB.length);
	        int[] after = Arrays.copyOfRange(arrB, 0, index);
	        
	        for(int i=0;i<before.length;++i) {
	        	if(arrA[i] != before[i]) {
	        		 return false;
	        	}
	        }
	        for(int i=0;i<after.length;++i) {
	        	if(arrA[before.length+i] != after[i]) {
	        		return false;
	        	}
	        }
	        
	        return answer;
	    }
	
	public static void main(String[] args) {

		int[] a = {7, 8, 10,11,12};
		int[] b = {7, 8, 10,12,11};
		System.out.println(solution(a,b));
		
		
	}

}
