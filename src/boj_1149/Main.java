package boj_1149;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][3];
		int[][] D = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int num = sc.nextInt();
				map[i][j] = num;
				if (i == 0) {
					D[i][j] = num;
				}
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					D[i][j] = Math.min(map[i - 1][j + 1] + map[i][j], map[i - 1][j + 2] + map[i][j]);
				}
				if (j == 1) {
					D[i][j] = Math.min(map[i - 1][j - 1] + map[i][j], map[i - 1][j + 1] + map[i][j]);
				}
				if (j == 2) {
					D[i][j] = Math.min(map[i - 1][j - 2] + map[i][j], map[i - 1][j - 1] + map[i][j]);
				}

			}
		}
		System.out.println(Math.min(D[N - 1][0], Math.min(D[N - 1][1], D[N - 1][2])));

	}

}
