package boj_1010;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// mCn
			int n = sc.nextInt();
			int m = sc.nextInt();

			int ans = 1;
			int cnt = 0;
			int i = 0;
			while (true) {
				ans *= m;
				m--;
				cnt++;
				if (cnt == n) {
					break;
				}
			}
			System.out.println(ans);

		}
	}

}
