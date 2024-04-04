package Comb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static void combination(int[] arr, List<Integer> result, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			System.out.println(result);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true; // 방문 표시를 true로 변경
				result.add(arr[i]); // 결과 리스트에 값을 추가
				combination(arr, result, visited, i + 1, depth + 1, r);
				result.remove(result.size() - 1); // 재귀 호출이 끝나면 마지막 요소를 제거하여 이전 상태로 복원
				visited[i] = false; // 방문 표시를 원래대로 false로 변경
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[arr.length];

		combination(arr, result, visited, 0, 0, 3);
	}

}
