import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {

	static int N; // 스위치 개수 <= 100
	static boolean[] sw;
	static int s; // 학생수 <= 100
	static int[][] student;

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (sw[i]) {
				sb.append(1 + " ");
			} else {
				sb.append(0 + " ");
			}

			if (i % 20 == 0) {
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		sw = new boolean[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			if (Integer.parseInt(st.nextToken()) == 0) {
				sw[i] = false;
			} else
				sw[i] = true;
		}

		s = Integer.parseInt(br.readLine());

		student = new int[s][2];

		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());

			student[i][0] = Integer.parseInt(st.nextToken()); // 성별
			student[i][1] = Integer.parseInt(st.nextToken()); // 스위치 번호
		}
		// 입력 완료

		// 어떻게 접근할 것인가?

		for (int i = 0; i < s; i++) {
			int g = student[i][0]; // 성별 변수
			int num = student[i][1]; // 스위치 번호

			if (g == 1) { // 남자인 경우
				for (int j = num; j <= N; j += num) {
					sw[j] = !sw[j];
				}
			} else {
				sw[num] = !sw[num]; // 일단 자기 자신 바꾸고
				for (int j = 1; j <= N / 2; j++) { // 좌우 한칸씩 비교하며 같을경우 스위치 변경
					if (num + j > N || num - j < 1 || sw[num + j] != sw[num - j]) { // (유효범위 체크)
						break;
					}
					sw[num + j] = !sw[num + j];
					sw[num - j] = !sw[num - j];
				}
			}
		}

		print();

		// 마지막 인덱스 오류를 못찾아서 헤맴..
	}

}
