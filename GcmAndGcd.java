package algorithm.first;

import java.util.Scanner;

public class GcmAndGcd {

	/*
	 * [최소공배수 / 최대공약수] / BOJ 2609
	 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
	 */
	
	private static int i;
	private static int j;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		i = sc.nextInt();
		j = sc.nextInt();
		
		if (j > i) {
			int k = j;
			j = i;
			i = k;
		}
		
		int result = gcd(i, j);
		System.out.println(result);
		System.out.println(i * j / result);
	}
	
	public static int gcd(int i, int j) {
		if (i % j == 0)
			return j;
		return gcd(j, i % j);
	}
}

//10554993	pp22shj	2609	맞았습니다!!	11348	104	Java / 수정	703	10초 전
