import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8320_직사각형을만드는방법 {

	static int n;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		// 입력 완료
		
		// 어떻게 접근할 것인가?
		
		// 1줄짜리, 2줄짜리, ...
		
		// 1줄짜리 = n
		// 2줄짜리 = (n / 2) - 1 (1x2)
		// 3줄짜리 = (n / 3) - 2 (1x3, 2x3)
		// n줄짜리 = (n / k) - (k-1) (1xn, 2xn, ..., kxn)
		
		// k <= (n^0.5)
		
		int cnt = 0;
		int k = (int) Math.sqrt(n);
		for (int i = 1; i <= k; i++) {
			cnt += (n/i) - (i-1);
		}
		
		System.out.println(cnt);

	}

}
