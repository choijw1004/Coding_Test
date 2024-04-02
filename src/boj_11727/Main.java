package boj_11727;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] D = new int[1007];

		D[1] = 1;
		D[2] = 3;

		for (int i = 3; i < N + 1; i++) {
			D[i] = (D[i - 1] + D[i - 2] * 2) % 10007;
		}

		System.out.println(D[N]);

	}

}
