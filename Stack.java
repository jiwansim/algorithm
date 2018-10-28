package algorithm.second;

import java.util.Scanner;

/*
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 명령은 총 다섯 가지이다.
 * 
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
 * 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 
 * 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 
 * Input :
 * 14
 * push 1
 * push 2
 * top
 * size
 * empty
 * pop
 * pop
 * pop
 * size
 * empty
 * pop
 * push 3
 * empty
 * top
 * 
 * output :
 * 2
 * 2
 * 0
 * 2
 * 1
 * -1
 * 0
 * 1
 * -1
 * 0
 * 3
 */
public class Stack {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 명령의 수
		int[] arr = new int[n];
		// 작업을 위한 배열
		int top = -1;
		// 배열 위치
		String input;
		// 명령
		for (int i = 0; i < n; i++) {
			input = sc.next();
			if (input.equals("push")) {
				top++;
				arr[top] = sc.nextInt();
			} else if (input.equals("pop")) {
				if (top == -1) {
					System.out.println(-1);
				} else {
					System.out.println(arr[top]);
					top--;
				}
			} else if (input.equals("size")) {
				System.out.println(top + 1);
			} else if (input.equals("empty")) {
				if (top == -1) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (input.equals("top")) {
				if (top == -1) {
					System.out.println(-1);
				} else {
					System.out.println(arr[top]);
				}
			}
		}
	}

}
