package swea_2112;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int r;
	static int c;
	static int target;
	static int[][] map;
	static int[][] tmpMap;
	static List<List<Integer>> combinationArr;
	static List<List<Integer>> powerSetArr;

	static void combination(int[] arr, List<Integer> result, boolean[] visited, int start, int depth, int r) {
		if (depth == r) {
			boolean[] combv = new boolean[result.size()];
			combinationArr.add(result);
			System.out.println(result);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result.add(arr[i]);
				combination(arr, result, visited, i + 1, depth + 1, r);
				result.remove(result.size() - 1);
				visited[i] = false;
			}
		}
	}

	static boolean isChecked(int[][] arr, int k) {
		String one = "";
		String zero = "";

		// check string
		for (int i = 0; i < k; i++) {
			one += "1";
			zero += "0";

		}

		List<String> checkStringArr = new ArrayList<String>();
		for (int j = 0; j < c; j++) {
			String check = "";
			for (int i = 0; i < r; r++) {
				check += map[i][j];
			}
			checkStringArr.add(check);
		}

		boolean checkFlag = false;

		for (int i = 0; i < checkStringArr.size(); i++) {
			if (checkStringArr.get(i).contains(zero) || checkStringArr.get(i).contains(one)) {
				checkFlag = true;
			}
		}
		return checkFlag;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int tc = 1;

		while (T-- > 0) {
			tc++;

			r = sc.nextInt();
			c = sc.nextInt();
			target = sc.nextInt();
			map = new int[r][c];

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			tmpMap = new int[r][c];

			// 원본 배열 복사
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					tmpMap[i][j] = map[i][j];
				}
			}

			// 행 조합 위한 배열들
			int[] checkArr = new int[r];
			boolean[] visited = new boolean[r];
			List<Integer> result = new ArrayList<Integer>();

			for (int i = 0; i < r; i++) {
				checkArr[i] = i;
			}
			combinationArr = new ArrayList<List<Integer>>();

			// 행 행 인덱스
			for (int i = 1; i <= target; i++) {
				combination(checkArr, new ArrayList<Integer>(), visited, 0, 0, i);
			}

			for (int i = 0; i < combinationArr.size(); i++) {
				System.out.println(combinationArr.get(i));
			}
		}
	}
}
