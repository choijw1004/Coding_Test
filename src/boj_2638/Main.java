package boj_2638;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int time;
	static int count;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void print(int[][] map) {
		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean endCheck(int[][] map) {
		boolean flag = true;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 디버깅 편하게
				if (map[i][j] != 9) {
					flag = false;
				}
			}
		}
		return flag;
	}

	static void bfs(int r, int c) {
		boolean[][] visited = new boolean[N][M];

		Queue<Integer> q = new LinkedList<Integer>();

		visited[r][c] = true;
		q.offer(r);
		q.offer(c);

		while (!q.isEmpty()) {
			int cr = q.poll();
			int cc = q.poll();

			// 치즈 있으면
			if (map[cr][cc] == 1) {
				continue;
			}

			// 외부면 9로
			// 디버깅 편하게
			map[cr][cc] = 9;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					continue;
				}

				q.offer(nr);
				q.offer(nc);
				visited[nr][nc] = true;
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		time = 0;
		map = new int[N][M];

		// 저장 배열
//		List<Integer> saveR = new ArrayList<>();
//		List<Integer> saveC = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (true) {
			if (endCheck(map)) {
				break;
			}
			// 저장한 값으로 map 다시 설정 0으로(녹은거니까)
//			for (int i = 0; i < saveR.size(); i++) {
//				map[saveR.get(i)][saveC.get(i)] = 0;
//			}

			// 바뀐 map에서 다시 bfs
			bfs(0, 0);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					count = 0;
					if (map[i][j] == 1) {
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];

							// 범위 안이고
							if (nr >= 0 || nr < N || nc >= 0 || nc < M) {
								// 닿은 면 9이면
								if (map[nr][nc] == 9) {
									count++;
								}
							}

						}
						if (count >= 2) {
							//저장
							map[i][j] = 0;
//							saveR.add(i);
//							saveC.add(j);
						}
					}
				}
			}

			time++;
		}

		System.out.println(time - 1);
//		print(map);
//		System.out.println(saveR);
//		System.out.println(saveC);

	}

}