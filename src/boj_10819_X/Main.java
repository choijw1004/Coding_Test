package boj_10819_X;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		List<Integer> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}

		Collections.sort(arr);
		int maxSum = Integer.MIN_VALUE;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		
	}

}
