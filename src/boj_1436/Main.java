package boj_1436;

import java.util.Scanner;

public class Main {

	static boolean isShom(int x) {

		String str = Integer.toString(x);

		if (str.contains("666")) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 0;
		for (int i = 1;; i++) {
			if (isShom(i)) {
				cnt++;
			}
			if (cnt == N) {
				System.out.println(i);
				break;
			}
		}

	}

}
