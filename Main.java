import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static int[][] map;
	static int[][] copyMap;
	static int[][] distMap;
	static int maxDist = 0;
	static int[] start = {0, 0};
	
//	static Scanner sc = new Scanner(System.in);

	// 보물섬 지도를 발견한 후크 선장은 보물을 찾아나섰다.
	// 보물섬 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다.
	// 각 칸은 육지(L)나 바다(W)로 표시되어 있다.
	// 이 지도에서 이동은 상하좌우로 이웃한 육지로만 가능하며, 한 칸 이동하는데 한 시간이 걸린다.
	// 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
	// 육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다.

	// 입력
	// 첫째 줄에는 보물 지도의 세로의 크기와 가로의 크기가 빈칸을 사이에 두고 주어진다.
	// 이어 L과 W로 표시된 보물 지도가 아래의 예와 같이 주어지며, 각 문자 사이에는 빈 칸이 없다.
	// 보물 지도의 가로, 세로의 크기는 각각 50이하이다.

	// 출력
	// 첫째 줄에 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력한다.

//	static void createMap(int a, int b) {
//		map = new int[a][b];
//
//		for (int i = 0; i < a; i++) {
//			for (int j = 0; j < b; j++) {
//				char ch = sc.next().charAt(j);
//				if (ch == 'W')
//					map[i][j] = -1;
//				else
//					map[i][j] = 9999;
//			}
//			sc.nextLine();
//		}
//	}
	
	static void showMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void calcDistance() {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0) {
					map[i][j] = 0;
					checkDistance(i, j, 0);
				}
			}
		}
	}

	static void checkDistance(int a, int b, int dist) {
	
//		int[][] distMap = new int[map.length][];
		System.arraycopy(map, 0, distMap, 0, map.length);	
		if(a >= 0 && a < map.length && b >= 0 && b < map.length && map[a][b] >= dist) {
			distMap[a][b] = dist + 1;
			dist = distMap[a][b];
			if (dist > maxDist) {
				start[0] = a;
				start[1] = b;
				maxDist = dist;
//				int[][] copyMap = new int[distMap.length][];
//				copyMap = distMap.clone();
				System.arraycopy(distMap, 0, copyMap, 0, distMap.length);
			}
			
			checkDistance(a-1, b, dist); // 상
			checkDistance(a+1, b, dist); // 하
			checkDistance(a, b-1, dist); // 좌
			checkDistance(a, b+1, dist); // 우
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("res/input.txt"));
		int a = sc.nextInt();
		int b = sc.nextInt();
//		createMap(a, b);
		map = new int[a][b];
		copyMap = new int[a][b];
		distMap = new int[a][b];

		for (int i = 0; i < a; i++) {
			String s = sc.next();
			for (int j = 0; j < b; j++) {
				char ch = s.charAt(j);
				if (ch == 'W')
					map[i][j] = -1;
				else
					map[i][j] = 99;
			}
		}
		showMap(map);
		calcDistance();
		System.out.println();
		showMap(copyMap);
		System.out.println();
		showMap(distMap);
		System.out.println();
		System.out.println(maxDist + 1);
		System.out.println(start[0] + " " + start[1]);
		
		
	}
}