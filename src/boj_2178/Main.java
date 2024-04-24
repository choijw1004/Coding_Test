package boj_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void print(int[][] map) {
		System.out.println("print");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int bfs(int r, int c) {
		visited = new boolean[N][M];
		int[][] dist = new int[N][M];
		visited[r][c] = true;

		Queue<Integer> q = new LinkedList<>();
		q.offer(r);
		q.offer(c);
		q.offer(1);

		while (!q.isEmpty()) {
			int cr = q.poll();
			int cc = q.poll();
			int distance = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}

				q.offer(nr);
				q.offer(nc);
				q.offer(distance + 1);
				visited[nr][nc] = true;

				dist[nr][nc] = distance + 1;
			}

		}
		return dist[N - 1][M - 1];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		int result = bfs(0, 0);

		System.out.println(result);

	}

}
