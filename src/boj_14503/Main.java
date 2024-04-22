package boj_14503;

import java.util.Scanner;

public class Main {

	// 북 동 남 서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static int R;
	static int C;

	// 4방 탐색을 했을 때 모두 0이 아님.
	static boolean stopCheck(int r, int c) {
		boolean flag = true;

		for (int i = 0; i < 4; i++) {
			int tmpR = r + dr[i];
			int tmpC = c + dc[c];

			if (map[tmpR][tmpC] == 0) {
				flag = false;
			}
		}
		return flag;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		map = new int[R][C];

		int r = sc.nextInt();
		int c = sc.nextInt();

		int direction = sc.nextInt();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (true) {

			if (stopCheck(r, c)) {
				break;
			}

			if (map[r][c] == 0) {
				map[r][c] = 2;
			}
			

		}
	}
}
