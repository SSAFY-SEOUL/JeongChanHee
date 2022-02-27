import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	
	static int R, C;
	static char map[][];
	static int[][] delta = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	static int step;
	
	static int[][] visited;
	static Queue<pos> GQ;
	static Queue<pos> WQ;
	
	static class pos {
		int x, y;
		
		public pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int bfs() {
		
		while(!GQ.isEmpty()) {
			step++;
			
			// 1. 물 넣고
			int wSize = WQ.size();
			for (int i = 0; i < wSize; i++) {
				pos water = WQ.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = water.x + delta[j][0];
					int nc = water.y + delta[j][1];
					
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
						map[nr][nc] = '*';
						WQ.add(new pos(nr, nc));
					}
				}
			}
			
			// 2. 고슴도치 움직이고
			int gSize = GQ.size();
			for (int i = 0; i < gSize; i++) {
				pos go = GQ.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = go.x + delta[j][0];
					int nc = go.y + delta[j][1];
					
					if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if (map[nr][nc] == 'D') {
							return step; // 비버굴 도달 가능하면 끝
						} else if (map[nr][nc] == '.') {
							map[nr][nc] = 'S';
							GQ.add(new pos(nr, nc));
						}
						
					}
				}
			}
		}
		
		return 0;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        WQ = new LinkedList<pos>();
        GQ = new LinkedList<pos>();
        
        for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '*') { // 물
					WQ.add(new pos(i, j));
				} else if(map[i][j] == 'S') { // 고슴도치
					GQ.add(new pos(i, j));
				}
			}
		}
        // 입력 완료
        
        // 어떻게 접근할 것인가?
        
        // 0. BFS 탐색을 이용해 최단거리를 출력
        // 1. 물 먼저 bfs 해서 map 변경
        // 2. 그 다음 고슴도치 bfs

        int result = bfs();
        if(result > 0) System.out.println(result);
        else System.out.println("KAKTUS");
	}

}
