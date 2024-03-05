package boj_10816;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] nums = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		int M = sc.nextInt();

		int[] target = new int[M];

		for (int i = 0; i < M; i++) {
			target[i] = sc.nextInt();
		}

		List<Integer> targetList = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (target[i] == nums[j]) {
					cnt++;
				}
			}
			targetList.add(cnt);
		}

		for(int i = 0 ; i < targetList.size(); i++) {
			System.out.print(targetList.get(i) + " ");
		}
	}

}
