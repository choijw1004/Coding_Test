package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int[] countingSort(int[] arr) {
		int[] checkArr = new int[Arrays.stream(arr).max().getAsInt() + 1];

		for (int i = 0; i < arr.length; i++) {
			checkArr[arr[i]]++;
		}
		List<Integer> copyArr = new ArrayList<Integer>();

		for (int i = 1; i < checkArr.length; i++) {
			if (checkArr[i] == 0) {
				continue;
			} else {
				copyArr.add(i);
				copyArr.add(checkArr[i]);
			}
		}
		int[] resultArr = new int[copyArr.size()];

		for (int i = 0; i < resultArr.length; i++) {
			resultArr[i] = copyArr.get(i);
		}

		return resultArr;
	}

	static int[][] calculateR(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int[] checkArr = new int[100];
			for (int j = 0; j < arr.length; j++) {
				checkArr[j] = arr[i][j];
			}
			countingSort(checkArr);
			arr[i] = Arrays.copyOf(checkArr, 100);
		}
		return arr;

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 45 }, { 12, 45, 2, 3, 1 }, { 1, 2, 45, 2, 3 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
			}
			System.out.println();
		}
	}

}
