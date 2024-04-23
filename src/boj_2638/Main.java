package boj_2638;

import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int time;
	static int c
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		time = 0;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

	}

}
