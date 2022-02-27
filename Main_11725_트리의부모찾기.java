import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	
	static int[][] map;
	static int[] visited;
	static int N;
	
	static void dfs(int n1, int n2) {
		
		if (visited[n2] != 0) {
			return;
		} else {
			visited[n2] = n1; // 방문값 배열에 부모 값을 저장해주고
		}
		
		for (int i = 0; i < map.length; i++) {
			if (map[n2][i] != 0) {
				dfs(n2, i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1]; // 메모리 초과 발생
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = map[c][r] = 1;
		}
		// map 입력완료

		visited = new int[N+1];
		dfs(1, 1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.print(sb.toString());
		
	}

}
