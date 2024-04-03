package boj_11053;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int maxLength;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			nums[i] = sc.nextInt();
		}

		int[] D = new int[N + 1];

		Arrays.fill(D, 1);
		D[0] = 0;

		for (int i = 2; i < N + 1; i++) {
			maxLength = 0;
			for (int j = i; j >= 1; j--) {
				if (nums[i] > nums[j]) {
					if (D[j] > maxLength) {
						maxLength = D[j];
					}
				}
			}
			D[i] += maxLength;
		}

		int sol = -1;
		for (int i = 0; i < D.length; i++) {
			if (D[i] > sol) {
				sol = D[i];
			}
		}
		System.out.println(sol);

	}
}
