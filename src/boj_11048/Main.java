package boj_11048;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();

		int[][] map = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0) {
					continue;
				}

				if (i == 0) {
					map[i][j] += map[i][j - 1];
				}

				if (j == 0) {
					map[i][j] += map[i - 1][j];
				}
			}
		}
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				map[i][j] = Math.max(map[i - 1][j] + map[i][j],
						Math.max(map[i - 1][j - 1] + map[i][j], map[i][j - 1] + map[i][j]));
			}
		}

		System.out.println(map[r - 1][c - 1]);
	}

}
