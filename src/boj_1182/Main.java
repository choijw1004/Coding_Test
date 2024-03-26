package boj_1182;

import java.util.Scanner;

public class Main {

	static int cnt;

	static void comb(int[] arr, int[] result, boolean[] visited, int start, int depth, int r, int target) {
		if (depth == r) {
			int sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}
			if (sum == target) {
				cnt++;
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				comb(arr, result, visited, i + 1, depth + 1, r, target);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int target = sc.nextInt();

		int[] nums = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}


		for (int i = 1; i <= nums.length; i++) {
			comb(nums, new int[N], visited, 0, 0, i, target);
		}
		
		System.out.println(cnt);

	}

}
