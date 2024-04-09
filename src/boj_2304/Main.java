package boj_2304;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[1001];

		Arrays.fill(arr, 0);
		
		for (int i = 0; i < N; i++) {
			int idx = sc.nextInt();
			int val = sc.nextInt();

			arr[idx] = val;
		}

		System.out.println(Arrays.toString(arr));

	}

}
