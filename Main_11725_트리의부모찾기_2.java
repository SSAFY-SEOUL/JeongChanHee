import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기_2 {
	
	static int[][] map;
	static int[] visited;
	static int N;
	static ArrayList<Integer>[] list;
	
	static void dfs(int v) { // 시작, 끝
		
		for (int num : list[v]) {
			if (visited[num] != 0) continue;
			visited[num] = v;
			dfs(num);
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[r].add(c);
			list[c].add(r);
		}
		// map 입력완료

		visited = new int[N+1];
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.print(sb.toString());
		
	}

}
