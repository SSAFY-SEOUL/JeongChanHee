import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {

	static class Tower {
		int id;
		int height;

		Tower(int i, int h) {
			this.id = i;
			this.height = h;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Tower> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				if (stack.peek().height >= h) {
					System.out.print(stack.peek().id + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.print(0 + " ");
			}

			stack.push(new Tower(i, h));
		}
	}

}
