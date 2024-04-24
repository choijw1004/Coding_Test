package boj_2206;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int min = 9999999;
	static List<Integer> saveR;
	static List<Integer> saveC;

	static void print(int[][] map) {
		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int bfs(int r, int c) {
		visited = new boolean[N][M];
		dist = new int[N][M];

		Queue<Integer> q = new LinkedList<>();

		visited[r][c] = true;

		q.offer(r);
		q.offer(c);
		q.offer(1);

		while (!q.isEmpty()) {
			int cr = q.poll();
			int cc = q.poll();
			int cdist = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == -1) {
					continue;
				}
				q.offer(nr);
				q.offer(nc);
				q.offer(cdist + 1);

				visited[nr][nc] = true;
				dist[nr][nc] = cdist + 1;
			}
		}

		return dist[N - 1][M - 1];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		saveR = new ArrayList<>();
		saveC = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				int num = line.charAt(j) - '0';
				if (num == 1) {
					map[i][j] = -1;
					saveR.add(i);
					saveC.add(j);
				} else
					map[i][j] = num;

			}
		}


		int min = 99999999;
//		saveR.size()
		boolean flag = false;

		for (int i = 0; i < saveR.size(); i++) {
			map[saveR.get(i)][saveC.get(i)] = 0;
			int result = bfs(0, 0);
			if (result != 0) {
				flag = true;
				min = Math.min(result, min);
			}
			map[saveR.get(i)][saveC.get(i)] = -1;
		}

		if (flag == false) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

}
