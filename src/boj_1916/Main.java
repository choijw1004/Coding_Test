package boj_1916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V, E, start;
	static ArrayList<ArrayList<Node>> graph;

	static class Node {
		int idx, cost;

		Node(int idx, int cost) {

			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		graph = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			graph.get(a).add(new Node(b, cost));
		}
		start = sc.nextInt();

		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (visited[curNode.idx]) {
				continue;
			}

			visited[curNode.idx] = true;

			for (Node nextNode : graph.get(curNode.idx)) {
				if (!visited[nextNode.idx] && dist[nextNode.idx] > dist[curNode.idx] + nextNode.cost) {
					dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
					pq.offer(new Node(nextNode.idx, dist[nextNode.idx]));
				}
			}
		}
		int target = sc.nextInt();

		System.out.println(dist[target]);
	}
}