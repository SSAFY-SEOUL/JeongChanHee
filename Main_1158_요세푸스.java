import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_요세푸스 {

	static List<Integer> s = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			s.add(i);
		}

		int cnt = 1;
		int idx = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while (!s.isEmpty()) {
			if (cnt == K) {
				sb.append(s.get(idx) + ", ");
				s.remove(idx--); // queue 
				cnt -= K;
			}
			cnt++;
			idx = (idx == s.size() - 1) ? idx - s.size() : idx;
			idx++;
			
			// cnt	idx
			// 1	0	> skip
			// 2	1	> skip
			// 0	2	> print g(2); r(2);
			// 1	3	> skip
			// 2	4	> skip
			// 0	5	> print g(5); r(5);
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");

		System.out.println(sb);
		s.clear();
	}

}
