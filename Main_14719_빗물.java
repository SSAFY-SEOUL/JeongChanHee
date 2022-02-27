import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
	
	static int H, W;
	static int[] map;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		// 입력완료
		
		// 어떻게 접근할 것인가?
		
		// 0. 제일 높은 블록 위치를 찾고 (기준블록)
		
		// 1. 왼쪽에서부터 기준블록까지 이동하면서
		//	1-1. 시작점(0)을 최대높이로 설정, 다음(1) 탐색
		//	1-2. 최대높이보다 낮으면 차이만큼 더하고, 높으면 최대높이를 갱신하고 다음 탐색 
		
		// 2. 오른쪽에서부터 기준블록까지 이동하면서
		//	2-1. 시작점(w-1)을 최대높이로 설정, 다음(w-2) 탐색
		//	2-2. 최대높이보다 낮으면 차이만큼 더하고, 높으면 최대높이를 갱신하고 다음 탐색
		
		int highest = 0;
		int highestIdx = 0;
		for (int i = 0; i < W; i++) {
			if(highest < map[i]) {
				highest = map[i];
				highestIdx = i;
			}
		}
		
		int cnt = 0;
		highest = map[0];
		for (int i = 1; i < highestIdx; i++) {
			if (highest > map[i]) {
				cnt += (highest - map[i]);
			} else {
				highest = map[i];
			}
		}
		
		highest = map[W-1];
		for (int i = W-2; i > highestIdx; i--) {
			if (highest > map[i]) {
				cnt += (highest - map[i]);
			} else {
				highest = map[i];
			}
		}
		
		System.out.println(cnt);
	}

}
