import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15666_N과M_12 {

	private static int N, M;
	private static int[] input;
	private static int[] result;

	private static void dfs(int start, int cnt) {

		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();

		} else {

			int num = 0;
			for (int i = start; i < N; i++) {
				if (input[i] > num) {
					result[cnt] = input[i]; // 1. 비교해서 크다면 선택하고
					dfs(i, cnt + 1);
					num = input[i]; // 2. 선택한 값을 비교값으로 저장
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		result = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 완료

		// 어떻게 접근할 것인가?

		// 1. 일단 정렬해놓고
		// 2. dfs 탐색하면서 직전 숫자보다 크거나 같은숫자만 선택
		
		// 중복 조합 > 입력받을때 중복을 제거해서 받아주면 더 깔끔해질수 있다
		Arrays.sort(input);

		dfs(0, 0);

	}

}