package boj_11724;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int V, E;
	static int[][] graph;
	static int[] parent;

	static int find(int x) {
		while (x != parent[x]) {
			x = parent[x];
		}
		return x;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		parent = new int[V];

		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		int cnt = 0;

		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (find(a - 1) != find(b - 1)) {
				union(a - 1, b - 1);
				cnt++;
				continue;
			}
		}

		System.out.println(V - cnt);
	}

}
