import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_10830 {

	static int[][] mat;
	static int N;

	static int[][] pow(int[][] m, long n) {

		int[][] temp = new int[N][N];

		if (n == 1) {
			// 1제곱은 자기 자신
			// multiply 연산을 하지 않기때문에 큰 수 처리 따로 해줘야 함
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = m[i][j] % 1000;
				}
			}
		} else if (n % 2 == 0) { // m^70 = (m^2)^35
			temp = pow(multiply(m, m), n/2);
			// 짝수 제곱의 경우 n을 2로 나누어 처리

		} else if (n % 2 == 1) { // m^71 = m * (m^70) 
			temp = multiply(m, pow(m, n-1));
			// 홀수 제곱의 경우 n-1로 짝수로 만들어 처리
		}

		return temp;
	}

	static int[][] multiply(int[][] m, int[][] n) { // 행렬 곱셈 표현식
		int[][] temp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					temp[i][j] += m[i][k] * n[k][j];
					
					temp[i][j] = temp[i][j] % 1000; // 1000보다 크면 자르기
				}
			}
		}
		
		return temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
//		long B = Integer.parseInt(st.nextToken()); // 1000억??
		long B = Long.parseLong(st.nextToken()); // 1000억??

		mat = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료
		
		int[][] res = new int[N][N];
		
		res = pow(mat, B);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(res[i][j] + " ");
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
