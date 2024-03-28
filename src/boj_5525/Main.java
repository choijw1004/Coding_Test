package boj_5525;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String str = sc.next();

		StringBuilder sb = new StringBuilder();

		sb.append("I");

		for (int i = 0; i < N; i++) {
			sb.append("OI");
		}

		int cnt = 0;

		for (int i = 0; i <= str.length() - sb.length(); i++) {
			StringBuilder checkSb = new StringBuilder();

			for (int j = i; j < i + sb.length(); j++) {
				checkSb.append(str.charAt(j));
			}

			if (checkSb.toString().equals(sb.toString())) {
				cnt++;
			}

		}
		System.out.println(cnt);

	}

}
