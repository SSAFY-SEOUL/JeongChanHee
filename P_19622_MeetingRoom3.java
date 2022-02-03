import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_19622_MeetingRoom3 {
	
	// 서준이는 아빠로부터 N개의 회의와 하나의 회의실을 선물로 받았다.
	// 각 회의는 시작 시간, 끝나는 시간, 회의 인원이 주어지고 한 회의실에서 동시에 두 개 이상의 회의가 진행될 수 없다.
	// 단, 회의는 한번 시작되면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
	// 회의의 시작 시간은 끝나는 시간보다 항상 작다.
	// N개의 회의를 회의실에 효율적으로 배정할 경우 회의를 진행할 수 있는 최대 인원을 구하자.
	
	// 입력
	// 첫째 줄에 회의의 수 N이 주어진다.
	// 둘째 줄부터 N + 1 줄까지 공백을 사이에 두고 회의의 시작시간, 끝나는 시간, 회의 인원이 주어진다.

	// 출력
	// 첫째 줄에 회의실에서 회의를 진행할 수 있는 최대 인원을 출력한다.
	
	// 제한
	// 1 ≤ N ≤ 100,000
	// 임의의 회의 K(1≤ K ≤ N)는 회의 K − 1과 회의 K + 1과는 회의 시간이 겹치고 다른 회의들과는 회의 시간이 겹치지 않는다.
	// 모든 회의의 시작 시간과 끝나는 시간은 231 − 1보다 작거나 같은 자연수 또는 0이다.
	// 모든 회의의 시작 시간과 끝나는 시간은 서로 다르다.
	// 회의 인원은 1,000보다 작거나 같은 자연수 이다.
	
	
	static int[] numP = new int[100000];
	static int[] max = new int[100000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numP[i] = Integer.parseInt(br.readLine().split(" ")[2]);
		}
		
		// 입력완료
		
//		N=1, t1 = 1
//		N=2, t2 = max(t1, 2)
//		N=3, t3 = max(t2, t1 + 3)
//		N=4, t4 = max(t3, t2 + 4)
//		N=5, t5 = max(t4, t3 + 5) ...
		
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				max[i] = numP[i];
			} else if (i == 1) {
				max[i] = Math.max(max[i-1], numP[i]);
			} else {
				max[i] = Math.max(max[i-1], max[i-2]+numP[i]);
			}
		}
		
		System.out.println(max[N-1]);
	}
}
