import java.util.Scanner;

public class P_1065_Hansu {
	
	// 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
	// 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
	// N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
	
	// 입력
	// 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
	
	// 출력
	// 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
	

	public static int hansu(int n) {
		if(n<100) return n;
		else {
			int cnt = hansu(99);
			for (int i = 100; i <= n; i++) {
				int a = i / 100;
				int b = (i % 100) / 10;
				int c = i % 10;
				if (a+c-2*b == 0) {
					cnt++;
				}
			} return cnt;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(hansu(n));
	}

}
