package algorithm.second;

import java.util.Scanner;
import java.util.Stack;

/*
 * 후위 표기식과 각 피 연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 피 연산자의 개수(1<=N<=26) 가 주어진다. 
 * 그리고 둘째 줄에는 후위표기식이 주어진다. 
 * (피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 
 * 길이는 100을 넘지 않는다)
 * 셋째 줄부터 3+N줄까지는 각 피 연산자에 대응하는 값이 주어진다. 
 * (3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 , 5번째 줄에는 C ...이 주어진다, 
 * 그리고 피 연산자에 대응 하는 값은 정수이다)
 * 
 * Input : 
 * 	5
 *	ABC*+DE/-
 *	1
 *	2
 *	3
 *	4
 *	5
 *
 * output :
 * 6.20
 */
public class Postfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        char[] s = sc.next().toCharArray();
	        int len = s.length;
	        double[] array = new double[n];
	        Stack<Double> stack = new Stack<Double>();
	 
	        for (int i = 0; i < n; i++) {
	            array[i] = sc.nextInt();
	        }
	 
	        for (int i = 0; i < len; i++) {
	            char ch = s[i];
	            
	            switch(ch) {
	            case '+':
	            case '-':
	            case '*':
	            case '/':
	                cal(stack, stack.pop(), stack.pop(), ch);
	                break;
	            default: 
	                stack.push(array[ch - 'A']);
	                break;
	            }
	        }
	        System.out.format("%.2f", stack.peek());
	    }
	 
	    public static void cal(Stack<Double> stack, double a, double b, char op) {
	        switch(op) {
	        case '+':
	            stack.push(b + a);
	            break;
	        case '-':
	            stack.push(b - a);
	            break;
	        case '*':
	            stack.push(b * a);
	            break;
	        case '/':
	            stack.push(b / a);
	            break;
	        }
	    }

}
