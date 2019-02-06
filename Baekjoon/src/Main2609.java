import java.util.Scanner;

public class Main2609 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(b>a) {
			int temp = b;
			b=a;
			a=temp;
		}
		int g = gcd(a,b);
		
		System.out.println(g);
		System.out.println(a*b/g);
	}

	private static int gcd(int x, int y) {
		while(y>0) {
			int temp =y;
			y=x%y;
			x=temp;
		}
		return x;
	}

}
