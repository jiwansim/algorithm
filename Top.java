package algorithm.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다.
 * 실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 
 * 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고, 
 * 각 탑의 꼭대기에 레이저 송신기를 설치하였다. 
 * 모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 
 * 수평 직선의 왼쪽 방향으로 발사하고, 
 * 탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다. 
 * 하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다. 
 * 예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고, 
 * 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 
 * 레이저 신호를 발사한다고 하자. 
 * 그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 
 * 높이가 7인 네 번째 탑이 수신을 하고, 
 * 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 
 * 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다. 
 * 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 
 * 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.
 * 
 * 탑들의 개수 N과 탑들의 높이가 주어질 때, 
 * 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.
 * 
 *  Input : 
 *  첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. 
 *  N은 1 이상 500,000 이하이다. 
 *  둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 
 *  하나의 빈칸을 사이에 두고 주어진다.
 *  탑들의 높이는 1 이상 100,000,000 이하의 정수이다.
 *  
 *  5
 *  6 9 5 7 4
 *  
 *  Output :
 *  첫째 줄에 주어진 탑들의 순서대로 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호를 하나의 빈칸을 사이에 두고 출력한다. 
 *  만약 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력한다.
 *  
 *  0 0 2 2 4
 */

public class Top {
		// TODO Auto-generated method stub
		private void solve() {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			Stack<Integer> rootStack = new Stack<>();
			Stack<Integer> indexStack = new Stack<>();

			int first = sc.nextInt();
			rootStack.push(first);
			indexStack.push(1);
			sb.append("0 ");
			for(int i=2;i<=n;i++) {
				int value = sc.nextInt();

				// 탑은 가장 가까이 존재하고 자신보다 높은 탑에 닿는다.
				// 좌측 탑들을 비교할 때 현재 탑보다 높이가 낮다면 더 이상 비교할 필요가 없다.
				// 예를 들어 7 9 가 존재한다면, 다음 탑이 3이라면 좌측 탑 중 9에 닿는다.
				// 이후 5가 들어온다면, 이전 탑 3이 아닌 9에 닿는다.
				// 이후 2가 들어온다면, 이전 탑 5에 닿는다.
				// 7 9 3 5 2 -> 왼쪽 탑보다 오른쪽 탑이 클 경우 왼쪽 탑은 무시해도 상관없다. 3과 5처럼 5가 높이 3을 막고 있기 때문이다.   
			
				while(!rootStack.isEmpty()) {
					if (value < rootStack.peek()) {
						sb.append(indexStack.peek() + " ");
						break;
					}
					rootStack.pop();
					indexStack.pop();
				}
				if (rootStack.isEmpty()) {
					sb.append("0 ");
				}
				rootStack.push(value);
				indexStack.push(i);
			}
			
			System.out.println(sb.toString());
		}
		
		public static void main(String[] args) {
			sc.init();

			new Top().solve();
		}
		
		static class sc {
			private static BufferedReader br;
			private static StringTokenizer st;

			static void init() {
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer("");
			}

			static String readLine() {
				try {
					return br.readLine();
				} catch (IOException e) {
				}
				return null;
			}

			static String readLineReplace() {
				try {
					return br.readLine().replaceAll("\\s+", "");
				} catch (IOException e) {
				}
				return null;
			}

			static String next() {
				while (!st.hasMoreTokens()) {
					try {
						st = new StringTokenizer(br.readLine());
					} catch (IOException e) {
					}
				}
				return st.nextToken();
			}

			static long nextLong() {
				return Long.parseLong(next());
			}

			static int nextInt() {
				return Integer.parseInt(next());
			}

			static double nextDouble() {
				return Double.parseDouble(next());
			}
		}
}
