package algorithm.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pibonacci {

	/*
	 * [피보나치] / BOJ 1003
	 * 다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
	 * int fibonacci(int n) {
     *  	if (n == 0) {
     *   		printf("0");
     *   	return 0;
     *		} else if (n == 1) {
     *   		printf("1");
     *   	return 1;
     *		} else {
     *   		return fibonacci(n‐1) + fibonacci(n‐2);
     *		}
	 *	}
	 *  fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
	 *  fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
	 *  fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
	 *  두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
	 *  fibonacci(0)은 0을 출력하고, 0을 리턴한다.
	 *  fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
	 *  첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
	 *  fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
	 *  ==> 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, 
	 *  fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
	 */

	static int count0 = 0;
	static int count1 = 0;
	static int[][] dp = new int[41][3];
	
	public static void main(String[] args) throws Exception, IOException {
		int t = 0;
		int n = 0;
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			count0 = 0;
			count1 = 0;
			
			if(dp[n][1] == -1 && dp[n][2] == -1) {
				fibonacci(n);
				dp[n][1] = count0;
				dp[n][2] = count1;
			}
			
			System.out.println(dp[n][1] + " " + dp[n][2]);
		}
	}
	
	static int fibonacci(int n) {
		if(dp[n][0] != -1) {
			count0 += dp[n][1];
			count1 += dp[n][2];
			return dp[n][0];
		} else {
			if(n == 0) {
				count0++;
				dp[n][0] = 0;
				return dp[n][0];
			} else if (n == 1) {
				count1++;
				dp[n][0] = 1;
				return dp[n][0];
			} else {
				dp[n][0] = fibonacci(n - 1) + fibonacci(n - 2);
				return dp[n][0];
			}
		}
	}
}
