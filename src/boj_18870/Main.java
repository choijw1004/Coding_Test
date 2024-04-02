package boj_18870;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> nums = new ArrayList<>();
		List<Integer> sortedNums = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			nums.add(n);
			sortedNums.add(n);
		}

		Collections.sort(sortedNums);

		HashMap<Integer, Integer> hashmap = new HashMap<>();

		int idx = 0;
		for (int x : sortedNums) {
			if (!hashmap.containsKey(x)) {
				hashmap.put(x, idx);
				idx++;
			}
		}
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(hashmap.get(nums.get(i)));
			sb.append(" ");
		}

		System.out.println(sb);

	}

}
