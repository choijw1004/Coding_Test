package boj_10973;

import java.util.Scanner;

public class Main {
	public static boolean prevPermutation(int[] nums) {
		int i = nums.length - 1;
		while (i > 0 && nums[i - 1] <= nums[i]) {
			i--;
		}
		if (i <= 0) {
			return false;
		}
		int j = nums.length - 1;
		while (nums[j] >= nums[i - 1]) {
			j--;
		}
		int temp = nums[i - 1];
		nums[i - 1] = nums[j];
		nums[j] = temp;
		j = nums.length - 1;
		while (i < j) {
			temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		if (!prevPermutation(nums)) {
			System.out.println(-1);
		} else {
			for (int num : nums) {
				System.out.print(num + " ");
			}
		}
	}
}
