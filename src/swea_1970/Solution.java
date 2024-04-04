package swea_1970;

import java.util.Scanner;

public class Solution {
	static int[] kindCoin = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
	static StringBuilder sb;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int tc = 1;
		while (T-- > 0) {
			int N = sc.nextInt();

			int[] resultCnt = new int[8];
			for (int i = 0; i < 8; i++) {

				if (N / kindCoin[i] > 0) {
					resultCnt[i] = N / kindCoin[i];
					N -= (N / kindCoin[i]) * kindCoin[i];
				}
			}
			sb = new StringBuilder();

			for (int x : resultCnt) {
				sb.append(x).append(" ");
			}
			
			System.out.println("#" + tc);
			System.out.println(sb);
			tc++;
		}

	}

}
