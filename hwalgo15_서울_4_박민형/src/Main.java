import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] temperature = new int[N][2];		// 온도 입력 받기 위한 배열
		int[][] refri = new int[N][10000+270+1];	// 냉장고 
		
		for(int i=0;i<N;++i) {
			temperature[i][0] = sc.nextInt();
			temperature[i][1] = sc.nextInt();
		}// 입력 끝
		
		// refri의 n행에 자기 온도 범위 만큼 1로 세팅
		for(int i=0;i<N;++i) {
			int a = temperature[i][0]+270;
			int b = temperature[i][1]+270;
			for(int j=a;j<=b;++j) {
				refri[i][j] = 1;
			}
		}
		
		boolean[] visited = new boolean[N];// 냉장고에 담긴 체크 배열
		int result = 0;		// 결과 값
		int flag; // do while탈출 위한 flag
		do {
			int max = Integer.MIN_VALUE;
			int sum = 0;
			int key=0;
			// 최대의 개수를 만족하는 열 찾기
			for(int j=0;j<10271;++j) {
				sum=0;
				for(int i=0;i<N;++i) {
					if(!visited[i]) {	// 아직 담기지 않은 물건만 체크
						sum += refri[i][j];
					}
				}
				if(sum!=0&&max<sum) {
					max = sum;	// max 갱신
					key = j;	// 해당 열 저장
				}
			}
			//	물건 담기
			for(int i=0;i<N;++i) {
				if(!visited[i]&&refri[i][key]==1)visited[i]=true;
			}
			result++;// 냉장고 수 +1
			flag = 0;
			for(int i=0;i<N;++i) {
				if(visited[i])flag++;
			}
			// 다 담겼으면 탈출
		}while(flag!=N);
		System.out.println(result);
		
	}

}
