package algorithm.first;

import java.util.Scanner;

public class Scale {

	/*
	 * [음계] / BOJ 2920
	 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 
	 * 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
	 * 1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 
	 * 둘 다 아니라면 mixed 이다.
	 * 
	 * ===> 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inputs = new int[8]; // 입력이 8개의 음계라서..
		
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = sc.nextInt();
		}
		
		sc.close();
		
		String output = ""; 
		for(int i=0; i<inputs.length -1; i++) {
			if (inputs[i] == inputs[i + 1] -1 ) {
				output = "ascending";
			} else if (inputs[i] == inputs[i + 1] + 1) {
				output = "descending";
			} else {
				output = "mixed";
				break;
			}
		}
		System.out.println(output);
	}
}

//10554967	pp22shj	2920	맞았습니다!!	11380	112	Java / 수정	738	
