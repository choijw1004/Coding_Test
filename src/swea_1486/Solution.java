package swea_1486;

import java.util.Scanner;

public class Solution {
	static int height;
	static int[] nums;
	static int diff;

	static int arrSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	static void combination(int[] nums, int[] result, boolean visited[], int start, int depth, int r) {
		if (r == depth) {
			if (arrSum(result) >= height) {
				diff = Math.min(diff, arrSum(result) - height);
			}

			return;
		}

		for (int i = start; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = nums[i];
				combination(nums, result, visited, i + 1, depth + 1, r);
				visited[i] = false;
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int tc = 1;

		while (T-- > 0) {

			int N = sc.nextInt();
			height = sc.nextInt();

			nums = new int[N];
			diff = 99999999;

			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			boolean[] visited = new boolean[N];

			for (int i = 1; i <= N; i++) {
				combination(nums, new int[N], visited, 0, 0, i);
			}
			System.out.println("#" + tc + " " + diff);
			tc++;
		}

	}

}
