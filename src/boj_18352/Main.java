package boj_18352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int V, E, target, start;
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
		target = sc.nextInt();
		start = sc.nextInt();

		graph = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = 1;
			graph.get(a).add(new Node(b, cost));
		}

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

		List<Integer> checkArr = new ArrayList<>();

		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == target) {
				checkArr.add(i);
			}
		}

		if (checkArr.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(checkArr);

			for (int i = 0; i < checkArr.size(); i++) {
				System.out.println(checkArr.get(i));
			}
		}
	}
}