package boj_2108;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		int sum = 0;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];

			if (arr[i] > max) {
				max = arr[i];
			}

			if (arr[i] < min) {
				min = arr[i];
			}
		}

		Arrays.sort(arr);

		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int count = frequencyMap.getOrDefault(arr[i], 0) + 1;
			frequencyMap.put(arr[i], count);
		}
		System.out.println(sum / N);
		System.out.println(arr[arr.length / 2]);

		// 최빈값과 두 번째로 작은 값을 추적합니다.
		int mode = Integer.MIN_VALUE;
		int secondMode = Integer.MIN_VALUE;
		int maxFrequency = 0;
		for (int key : frequencyMap.keySet()) {
			int count = frequencyMap.get(key);
			if (count > maxFrequency) {
				secondMode = mode;
				maxFrequency = count;
				mode = key;
				System.out.println(mode);
			} else if (count > frequencyMap.getOrDefault(secondMode, 0) && key != mode) {
				secondMode = key;
				System.out.println(secondMode);
			}
		}
		System.out.println(max - min);
	}

}
