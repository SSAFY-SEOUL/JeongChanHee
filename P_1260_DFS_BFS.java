import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P_1260_DFS_BFS {
	
	// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
	// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
	// 정점 번호는 1번부터 N번까지이다.
	
	// 입력
	// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
	// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
	// 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
	// 입력으로 주어지는 간선은 양방향이다.

	// 출력
	// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
	// V부터 방문된 점을 순서대로 출력하면 된다.
	
	
	static int[][] graph = new int[1001][1001];
	static List<Integer> queue = new ArrayList<>();
	static int[] visited = new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);

		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			String[] edge = br.readLine().split(" ");
			int x = Integer.parseInt(edge[0]);
			int y = Integer.parseInt(edge[1]);

			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(V);
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		System.out.println();
		bfs(V);
	}
	
	static void dfs(int v) {
		if (visited[v] == 1) {
			return;
		} else {
			System.out.print(v + " ");
			visited[v] = 1;
		}
		
		for (int i = 0; i < graph.length; i++) {
			if (graph[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		queue.add(v);
		while(!queue.isEmpty()) {
			v = queue.get(0);
			if(visited[v] == 0) {
				System.out.print(v + " ");
				visited[v] = 1;
			}
			
			for (int i = 0; i < graph.length; i++) {
				if (graph[v][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
					System.out.print(i + " ");
				}
			}
			queue.remove(0);
		}
	}

}
