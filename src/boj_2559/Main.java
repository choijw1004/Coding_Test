package boj_2559;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int target = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i <= N - target; i++) {
			int sum = 0;
			for (int j = i; j < i + target; j++) {
				sum += arr[j];
			}
			if (maxSum < sum) {
				maxSum = sum;
			}
		}
		System.out.println(maxSum);

	}

}

