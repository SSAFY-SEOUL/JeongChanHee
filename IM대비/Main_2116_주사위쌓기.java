import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2116_주사위쌓기 {

	static int n; // 주사위 개수 <= 10000
	static int[][] dice;
	static int maxSum;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		dice = new int[n][6];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료

		// 어떻게 접근할 것인가?

		// 밑면 A 선택하면 F가 윗면 (반대도 동일) (0, 5)
		// 밑면 B 선택하면 D가 윗면 (1, 3)
		// 밑면 C 선택하면 E가 윗면 (2, 4)
		// {5, 3, 4, 1, 2, 0} >> i번째를 밑면으로 선택했을때 결정되는 윗면 인덱스

		// 첫번째 주사위 밑면을 정하면 그 이후는 자동으로 정해짐.

		// 첫번째 주사위 3가지 경우를 돌면서, 각각의 주사위 옆면에 해당하는 숫자들 중 최대값을 더해준다.

		int[] idx = { 5, 3, 4, 1, 2, 0 };

		for (int i = 0; i < 6; i++) {
			int sum = 0;
			int max = 0;
			if (i == 0 || i == 5) {
				for (int j = 0; j < 6; j++) {
					if (j != 0 && j != 5) {
						max = Math.max(max, dice[0][j]);
					}
				}
			} else if (i == 1 || i == 3) {
				for (int j = 0; j < 6; j++) {
					if (j != 1 && j != 3) {
						max = Math.max(max, dice[0][j]);
					}
				}
			} else if (i == 2 || i == 4) {
				for (int j = 0; j < 6; j++) {
					if (j != 2 && j != 4) {
						max = Math.max(max, dice[0][j]);
					}
				}
			}
			sum += max;
			int last = dice[0][idx[i]]; // 0번째 주사위 윗면의 숫자
			// 0번째 주사위
			// 이후 1번째 주사위 부터
			for (int j = 1; j < n; j++) {
				max = 0;
				for (int k = 0; k < 6; k++) {
					if (dice[j][k] == last) {
						if (k == 0 || k == 5) {
							for (int l = 0; l < 6; l++) {
								if (l != 0 && l != 5) {
									max = Math.max(max, dice[j][l]);
								}
							}
						} else if (k == 1 || k == 3) {
							for (int l = 0; l < 6; l++) {
								if (l != 1 && l != 3) {
									max = Math.max(max, dice[j][l]);
								}
							}
						} else if (k == 2 || k == 4) {
							for (int l = 0; l < 6; l++) {
								if (l != 2 && l != 4) {
									max = Math.max(max, dice[j][l]);
								}
							}
						}
						sum += max;
						last = dice[j][idx[k]];
						break;
					}
				}
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);

	}

}
