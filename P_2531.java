import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class P_2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int d = Integer.parseInt(str.split(" ")[1]);
		int k = Integer.parseInt(str.split(" ")[2]);
		int c = Integer.parseInt(str.split(" ")[3]);

		int[] belt = new int[N+k];
		int eat_cnt = 0;
		int max_cnt = 0;
		
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		// 입력 완료
		
		for (int i = N; i < belt.length; i++) {
			belt[i] = belt[i-N];
		}
		// 추가 입력
		
		ArrayList <Integer> eat = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			eat.add(belt[i]);
		}
		
		for (int i = k; i <= N; i++) {
			Set <Integer> eat_set = new HashSet<>(eat);
			if (!eat_set.contains(c)) {
				eat_cnt = eat_set.size() + 1;
			} else eat_cnt = eat_set.size();
			if (eat_cnt > max_cnt) max_cnt = eat_cnt;
			
			eat.remove(0);
			eat.add(belt[i]);
		}
		
		Set <Integer> eat_set = new HashSet<>(eat);
		if (!eat_set.contains(c)) {
			eat_cnt = eat_set.size() + 1;
		} else eat_cnt = eat_set.size();
		if (eat_cnt > max_cnt) max_cnt = eat_cnt;

//		for (int i = 0; i < belt.length; i++) {
//			Set<Integer> eat = new HashSet<>();
//			for (int j = 0; j < k; j++) {
//				int idx = i+j;
//				if (idx >= belt.length) idx -= belt.length;
//				eat.add(belt[idx]);
//			}
//			if (!eat.contains(c)) {
//				eat_cnt = eat.size() + 1;
//			} else eat_cnt = eat.size();
//			
//			if (eat_cnt > max_cnt) max_cnt = eat_cnt;
////			max_cnt = Math.max(max_cnt, eat_cnt);
//		}

		
		bw.write(max_cnt + "\n");
		bw.close();
//		System.out.println(max_cnt);
	}

}
