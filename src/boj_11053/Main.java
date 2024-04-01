package boj_11053;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int maxLength;

	public static void comb(int[] arr, int[] result, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			System.out.println(Arrays.toString(result));
			System.out.println(arrLength(result));
			
			if (isChecked(result) && arrLength(result) >= maxLength) {
				maxLength = result.length;
			}
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

	public static boolean isChecked(int[] result) {
		boolean checkFlag = true;
		for (int i = result.length - 1; i >= 1; i--) {
			if (result[i] == 0) {
				continue;
			}
			if (result[i - 1] > result[i]) {
				checkFlag = false;
			}
		}
		return checkFlag;
	}

	public static int arrLength(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			} else
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];

		maxLength = -1;
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		boolean[] visited = new boolean[N];

		for (int i = 1; i <= N; i++) {
			comb(nums, new int[N], visited, 0, 0, i);
		}
	}
}
