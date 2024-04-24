package boj_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int time;
	static int[][] dist;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void print(int[][] map) {
		System.out.println("test");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void bfs(int r, int c) {
		visited = new boolean[N][M];
		int[][] distArr = new int[N][M];

		Queue<Integer> q = new LinkedList<>();

		q.offer(r);
		q.offer(c);
		q.offer(1);
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int cr = q.poll();
			int cc = q.poll();
			int dist = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == -1) {
					continue;
				}

				q.offer(nr);
				q.offer(nc);
				q.offer(dist + 1);

				visited[nr][nc] = true;
				distArr[nr][nc] = dist + 1;
			}
		}
		print(distArr);

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs(3, 5);
	}

}
