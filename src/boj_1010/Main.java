package boj_1010;

import java.util.Scanner;

public class Main {
	static int cnt;

	public static void comb(int[] arr, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			cnt++;
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(arr, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] nums = new int[M];
			boolean[] visited = new boolean[M];

			cnt = 0;
			for (int i = 0; i < M; i++) {
				nums[i] = i;
			}

			comb(nums, visited, 0, 0, N);

			System.out.println(cnt);
		}
	}

}
