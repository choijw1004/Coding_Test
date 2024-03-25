package boj_1759;

import java.util.Arrays;
import java.util.Scanner;

//4 6
//a t c i s w

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static boolean alphaCheck(char[] arr) {
		int cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				cnt++;
			}
		}
		if (cnt >= 1 && arr.length - cnt >= 2) {
			return true;
		}
		return false;
	}

	public static boolean check(char[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}
		return true;
	}

	// && alphaCheck(result) == true
	public static void permutation(char[] arr, char[] result, boolean[] visited, int depth, int r) {
		if (depth == r) {
			if (check(result) == true && alphaCheck(result) == true) {
				for (char x : result) {
					sb.append(x);
				}
				sb.append("\n");
				return;
			} else {
				return;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = arr[i];
				permutation(arr, result, visited, depth + 1, r);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		char[] chars = new char[M];
		boolean[] visited = new boolean[M];

		for (int i = 0; i < M; i++) {
			chars[i] = sc.next().charAt(0);
		}

		Arrays.sort(chars);
		permutation(chars, new char[N], visited, 0, N);

		System.out.println(sb);
	}
}
