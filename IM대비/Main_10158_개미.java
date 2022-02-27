import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {
	
	static int w, h; // 격자 크기 (x, y)
	static int p, q; // 시작 좌표 (p, q)
	static int t; // 시간
	
	static boolean flagX, flagY;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		t = Integer.parseInt(br.readLine());
		
		// 입력 완료
		
		// 어떻게 접근할 것인가?
		
		
		// 0. 어디서 시작하든 w*h 시간이 지나면 원래 위치로 돌아오게 됨 (방향도 원래대로)
		// 따라서 t를 w*h 로 나눈 나머지를 t로 설정해서 실행하면 될듯
		
		// 0-1. 시작좌표에서 2w 지나면 p -> p;
		//	t % 2w 처리해서 p좌표 계산
		// 0-2. 시작좌표에서 2h 지나면 q -> q;
		//	t % 2h 처리해서 q좌표 계산
		
		// 1. t만큼 반복 실행
		
		//	2. x 혹은 y가 벽에 닿을때 다음 x, y 증감을 결정
		
		int t1, t2;
		t1 = t % (2*w);
		t2 = t % (2*h);
		
		int deltaX = 1, deltaY = 1;
		
		for (int i = 0; i < t1; i++) {
			int nx = p + deltaX;
			
			if (nx == 0 || nx == w) { // x좌표가 벽에 닿았다?
				deltaX *= -1;
			}
			p = nx;
		}
		
		for (int i = 0; i < t2; i++) {
			int ny = q + deltaY;
			
			if (ny == 0 || ny == h) { // y좌표가 벽에 닿았다?
				deltaY *= -1;
			}
			q = ny;
		}
		
		System.out.println(p + " " + q);

		// 시초
		// 시초2
		
	}

}
