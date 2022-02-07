import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int d = Integer.parseInt(str.split(" ")[1]);
		int k = Integer.parseInt(str.split(" ")[2]);
		int c = Integer.parseInt(str.split(" ")[3]);

		int[] belt = new int[N];
		int eat_cnt = 0;
		int max_cnt = 0;
		
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		// 입력 완료

        	Set<Integer> eat = new HashSet<>();
		for (int i = 0; i < belt.length; i++) {
			for (int j = 0; j < k; j++) {
				int idx = i+j;
				if (idx >= belt.length) idx -= N;
				eat.add(belt[idx]);
			}
            		eat.add(c);
            		eat_cnt = eat.size();
            
			max_cnt = Math.max(max_cnt, eat_cnt);
            		eat.clear();
		}
        
        	System.out.println(max_cnt);
	}

}
