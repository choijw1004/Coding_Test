package boj_15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void comb_d(int[] arr, int[] result, int start, int depth, int r) {
		if (depth == r) {
			for (int num : result) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < arr.length; i++) {
			result[depth] = arr[i];
			comb_d(arr, result, start, depth + 1, r);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);

		comb_d(nums, new int[M], 0, 0, M);
		System.out.println(sb);
	}
}
