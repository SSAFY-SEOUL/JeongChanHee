import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1965_Box_in_Box {
  
  // 정육면체 모양의 상자가 일렬로 늘어서 있다.
  // 상자마다 크기가 주어져 있는데, 앞에 있는 상자의 크기가 뒤에 있는 상자의 크기보다 작으면, 앞에 있는 상자를 뒤에 있는 상자 안에 넣을 수가 있다.
  // 예를 들어 앞에서부터 순서대로 크기가 (1, 5, 2, 3, 7)인 5개의 상자가 있다면, 크기 1인 상자를 크기 5인 상자에 넣고, 다시 이 상자를 크기 7인 상자 안에 넣을 수 있다.
  // 하지만 이렇게 상자를 넣을 수 있는 방법은 여러 가지가 있을 수 있다.
  // 앞의 예에서 차례대로 크기가 1, 2, 3, 7인 상자를 선택하면 총 4개의 상자가 한 개의 상자에 들어가게 된다.

  // 상자의 크기가 주어질 때, 한 번에 넣을 수 있는 최대의 상자 개수를 출력하는 프로그램을 작성하시오.

  // 입력
  // 파일의 첫 번째 줄은 상자의 개수 n (1 ≤ n ≤ 1000)을 나타낸다.
  // 두 번째 줄에는 각 상자의 크기가 순서대로 주어진다.
  // 상자의 크기는 1,000을 넘지 않는 자연수이다.

  // 출력
  // 첫째 줄에 한 줄에 넣을 수 있는 최대의 상자 개수를 출력한다.

	static int[] box = new int[1000];
	static int[] cnt = new int[1000];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int maxCnt = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < T; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		// 입력완료

		// box : 1 3 7 2 6 4 3 5 8
		// cnt : 1 2 3 1 3...
		for (int i = 0; i < T; i++) {
			int tmp = 0;
			cnt[i] = 1;
			for (int j = 0; j < i; j++) {
				if (box[j] < box[i] && cnt[j] > tmp) {
					tmp = cnt[j];
				}
			}
			cnt[i] = tmp + 1;
			if(cnt[i] > maxCnt) maxCnt = cnt[i];
		}

		System.out.println(maxCnt);
	}

}
