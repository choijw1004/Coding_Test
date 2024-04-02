package boj_11047;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int target = sc.nextInt();

		int[] coins = new int[N];
 
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}

		int cnt = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (coins[i] > target) {
				continue;
			}

			int mod = target / coins[i];
			cnt += mod;
			target = target - (coins[i] * mod);

			if (target == 0) {
				break;
			}

		}
		System.out.println(cnt);

	}

}
