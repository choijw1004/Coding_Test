package boj_17140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int targetR, targetC, targetVal, time;
	static int[][] map;

	// 1이면 R연산, 0이면 C연산
	static int calcuDirection(int[][] arr) {

		int maxRCnt = -1;
		int maxCCnt = -1;

		for (int i = 0; i < arr.length; i++) {
			int rCnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					break;
				}
				rCnt++;
			}
			if (rCnt >= maxRCnt) {
				maxRCnt = rCnt;
			}

		}

		for (int j = 0; j < arr.length; j++) {
			int cCnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i][j] == 0) {
					break;
				}
				cCnt++;
			}
			if (cCnt >= maxCCnt) {
				maxCCnt = cCnt;
			}
		}

		if (maxRCnt >= maxCCnt) {
			return 1;
		} else
			return 0;

	}

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

//	static int calculateC(int[][] arr) {
//
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		targetR = sc.nextInt();
//		targetC = sc.nextInt();
//		targetVal = sc.nextInt();
//		time = 0;
//
//		map = new int[100][100];
//
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		}
		int[] arr = { 1, 65, 2, 3, 2, 4, 1, 2, 3 };
		System.out.println(Arrays.toString(countingSort(arr)));
		boolean successFlag = false;

	}
}
