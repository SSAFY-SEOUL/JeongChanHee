import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5639_이진검색트리 {
	
	static int[] arr;
	
	static void find(int start, int end) {
		// arr : 50 30 24 5 28 45 98 52 60
		
		// Left, Right, Parent 순서로 출력해야함
		// (30 24 5 28 45) / (98 52 60) / 50
		// ((24 5 28) / 45 / 30) / (52 60 / x / 98) / 50
		// ((5 / 28 / 24) / 45 / 30) / ((x / 60 / 52) / x / 98) / 50
		
		// find(0, i-1)
		// (50) 30 24 5 28 45 / 98 52 60	--> parent : 50, idx : 5
		
			// find(1, 5) Left
			// 50 (30) 4 5 28 / 45 98 52 60		--> parent : 30, idx : 4
		
				// find(2, 4) Left
				// 50 30 (24) 5 / 28 45 98 52 60	--> parent : 24, idx : 3
		
					// find(3, 3) Left
					// 50 30 24 (5) / 28 45 98 52 60	--> parent : 5, idx : 3
		
		// result : 5 28 24 45 30 60 52 98 50
		
		if (start > end) return;
		
		int parent = arr[start];
		int idx = end;
		
		while (arr[idx] > parent){
			idx--; // root 보다 작은값이 나올때까지 idx 줄여가고
		}
		
		find(start + 1, idx); // Left 처리
		
		find(idx+1, end); // Right 처리
		
		System.out.println(parent);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		arr = new int[10001];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i = 0;
		String next;
		while ((next = br.readLine()) != null && next.length() != 0) {
			arr[i++] = Integer.parseInt(next);
		}
		// 입력 완료

		
		find(0, i-1);
		
		
		
		

	}

}
