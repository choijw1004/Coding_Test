package swea_2105;

import java.util.Scanner;

//10
//4
//9 8 9 8
//4 6 9 4
//8 7 7 8
//4 5 3 5

class Solution {
	static int max;
	static int startR, startC;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	// 1 1
	// 1 -1
	// -1 -1
	// -1 1
	static boolean[] visited;

	static void dfs(int direction, int cnt, int currR, int currC, int prevR, int prevC, int[][] map) {
		for (int d = direction; d < 4; d++) {
			int nextR = currR + dr[d];
			int nextC = currC + dc[d];

			// 범위 밖
			if (nextR >= map.length || nextR < 0 || nextC >= map.length || nextC < 0) {
				continue;
			}

			// 돌아가는 경우
			else if (nextR == prevR && nextC == prevC) {
				continue;
			}

			// 도착
			else if (nextR == startR && nextC == startC && cnt >= max) {
				max = cnt + 1;
				return;
			}
			
			// 방문했던 경우
			else if (visited[map[nextR][nextC]])
				continue;

			// else
			else {

				// 방문처리
				visited[map[nextR][nextC]] = true;
				dfs(d, cnt + 1, nextR, nextC, currR, currC, map);
				visited[map[nextR][nextC]] = false;
			}
		}

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;

		while (T-- > 0) {

			int N = sc.nextInt();
			int[][] map = new int[N][N];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {

					startR = i;
					startC = j;

					visited = new boolean[101];
					visited[map[i][j]] = true;

					dfs(0, 0, i, j, 0, 0, map);
				}
			}

			if (max == Integer.MIN_VALUE) {
				System.out.println("#" + tc + " " + -1);
			} else {
				System.out.println("#" + tc + " " + max);
			}
			tc++;
		}
	}
}