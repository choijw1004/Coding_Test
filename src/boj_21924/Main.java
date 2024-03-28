package boj_21924;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	static class Edge implements Comparable<Edge> {
		int st, ed, w;

		public Edge(int st, int ed, int w) {
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		List<Edge>[] adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		long totalSum = 0;
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();

			totalSum += W;

			adjList[A - 1].add(new Edge(A - 1, B - 1, W)); // 정점 번호를 0부터 시작하도록 수정
			adjList[B - 1].add(new Edge(B - 1, A - 1, W)); // 정점 번호를 0부터 시작하도록 수정
		}

		boolean[] visited = new boolean[V];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		visited[0] = true;

		for (Edge e : adjList[0]) {
			pq.add(e);
		}

		int pick = 1;
		long ans = 0;

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (visited[e.ed])
				continue;

			ans += e.w;
			visited[e.ed] = true;
			pick++;

			for (Edge next : adjList[e.ed]) {
				if (!visited[next.ed]) {
					pq.add(next);
				}
			}
		}

		if (pick != V) {
			System.out.println(-1); // 모든 정점이 연결되어 있지 않은 경우
		} else {
			System.out.println(totalSum - ans);
		}
	}
}
