package boj_11726;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] D = new int[1001];

		D[1] = 1;
		D[2] = 2;

		for (int i = 3; i < N + 1; i++) {
			D[i] = (D[i - 2] + D[i - 1]) % 10007;
		}

		System.out.println(D[N]);
	}

}
