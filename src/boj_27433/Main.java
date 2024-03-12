package boj_27433;

import java.util.Scanner;

public class Main {

	static long facto(int n) {
		if (n == 1 || n == 0) {
			return 1;
		}

		return n * facto(n - 1);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long sol = 1;
		sol = facto(N);

		System.out.println(sol);
	}

}
