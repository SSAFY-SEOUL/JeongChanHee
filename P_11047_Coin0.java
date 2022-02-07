import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11047_Coin0 {
	
	static int[] money;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int K = Integer.parseInt(str.split(" ")[1]);
		
		money = new int[N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = N-1; i >= 0; i--) {
			if (K == 0) break;
			
			while(K >= money[i]) {
				K -= money[i];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
