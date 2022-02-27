import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

	static int[][] map = new int[100][100];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 10; j++) {
				int nr = r + j;
				for (int k = 0; k < 10; k++) {
					int nc = c + k;
					
					if (map[nr][nc] != 0) continue;
					else map[nr][nc] = 1;
				}
			}
		}
		// 입력 완료
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				cnt += map[i][j];
			}
		}
		
		System.out.println(cnt);
	}

}
