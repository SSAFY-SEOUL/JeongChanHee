import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {

	static char[] S; // 문자열 <= 100000
	static boolean checkTag;

	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		S = br.readLine().toCharArray();
		
		// 입력 완료
		
		// 어떻게 접근할 것인가?
		
		// 0. stack 사용 (거꾸로 출력)
		
		// 1. 괄호안의 문자는 정상적으로 출력해야하므로 boolean 변수 사용
		
		// 2. 여는 괄호나 공백을 만나면 스택에 넣었던 문자들을 차례로 출력
		//	닫는 괄호는 여는 괄호 이후에만 나오고, 괄호 안의 문자는 정상 출력
		

		stack = new Stack<>();

		for (char ch : S) {
			if (ch == '<') { // 여는 괄호를 만나면
				while (!stack.isEmpty()) { // 스택에 넣어둔 문자들을 출력
					sb.append(stack.pop());
				}
				sb.append(ch);
				checkTag = true; // 괄호 상태 > 열림
			} else if (ch == '>') { // 닫는 괄호는 그대로 출력
				sb.append(ch);
				checkTag = false; // 괄호 상태 > 닫힘
			} else if (checkTag) { // 괄호 안의 문자는 stack 넣지 않고 그대로 출력
				sb.append(ch);
			} else if (ch == ' ') { // 공백 만나면
				while (!stack.isEmpty()) { // 스택에 넣어둔 문자들을 출력
					sb.append(stack.pop());
				}
				sb.append(ch);
			} else { // 나머지는 스택으로
				stack.push(ch);
			}
		}

		while (!stack.isEmpty())

		{
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());

	}

}
