import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_7562 {

	static int[][] map;
	static int[] start;
	static int[] end;
	
	static int[][] delta = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
	
	static Queue<int[]> cmap = new LinkedList<>(); 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int I = Integer.parseInt(br.readLine());

			map = new int[I][I];
			start = new int[2];
			end = new int[2];

			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			int step = 0;
			
			cmap.offer(start); // 시작 좌표 집어넣고
			map[start[0]][start[1]] = 1;
			
			while (!cmap.isEmpty()) {
				int[] temp = cmap.poll();
				step = map[temp[0]][temp[1]];
				
				if (temp[0] == end[0] && temp[1] == end[1]) {
					break;
				}
				
				for (int j = 0; j < 8; j++) {
					int nr = temp[0] + delta[j][0];
					int nc = temp[1] + delta[j][1];
					
					if (nr >= 0 && nr < I && nc >= 0 && nc < I && map[nr][nc] == 0) {
						int[] n = {nr, nc};
						map[nr][nc] = step+1;
						cmap.offer(n);
					}
				}
			}
			cmap.clear();
			
			step = map[end[0]][end[1]] - 1; // 시작 step을 1로 설정했기때문에 최종 출력은 -1 해야함
			
			System.out.println(step);
		}

	}

}
