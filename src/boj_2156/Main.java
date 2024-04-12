package boj_2156;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		int[] D = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		if (N == 1) {
			D[0] = arr[0];

		}
		if (N == 2) {
			D[1] = arr[1] + arr[0];
		}
		
		if (N > 2) {
			D[0] = arr[0];
			D[1] = arr[1] + arr[0];

			D[2] = Math.max(arr[0] + arr[2], Math.max(arr[1] + arr[2], D[1]));

			for (int i = 3; i < N; i++) {
				D[i] = Math.max(arr[i] + arr[i - 1] + D[i - 3], Math.max(D[i - 1], D[i - 2] + arr[i]));

			}
		}
		System.out.println(D[N - 1]);
	}

}
