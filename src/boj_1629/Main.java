package boj_1629;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}

		Arrays.sort(a);
		Arrays.sort(b);

		int sum = 0;

		for (int i = 0, j = N - 1; i < N; i++, j--) {
			sum += a[i] * b[j];
		}
		
		System.out.println(sum);

	}

}

