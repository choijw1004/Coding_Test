package boj_6603;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static void comb(int[] arr, int[] result, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			for (int x : result) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				comb(arr, result, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();

			if (N == 0) {
				break;
			}

			int[] nums = new int[N];
			boolean[] visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			comb(nums, new int[6], visited, 0, 0, 6);
			System.out.println();
		}

	}

}
