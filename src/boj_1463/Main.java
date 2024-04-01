package boj_1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 0;

		while (true) {
			if (N == 1) {
				break;
			}
			if (N % 3 == 0) {
				N = N / 3;
				cnt++;
				continue;
			} else if (N % 2 == 0) {
				N = N / 2;
				cnt++;
				continue;
			} else
				N = N - 1;
			cnt++;
			continue;
		}

		System.out.println(cnt);

	}

}
