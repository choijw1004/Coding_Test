package boj_18111_X;

import java.util.Scanner;

public class Main {

	static int r, c, invenCnt, time;
	static int[][] map;

	static int calcuMax(int[][] map) {
		int maxCnt = -9999999;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				maxCnt = Math.max(maxCnt, map[i][j]);
			}
		}

		return maxCnt;
	}

	static int calcuMin(int[][] map) {
		int minCnt = 9999999;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				minCnt = Math.min(minCnt, map[i][j]);
			}
		}

		return minCnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		r = sc.nextInt();
		c = sc.nextInt();
		invenCnt = sc.nextInt();
		time = 0;
		
		map = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (true) {
			if (calcuMax(map) == calcuMin(map)) {
				break;
			}

		}
	}

}
