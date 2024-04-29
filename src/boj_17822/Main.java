package boj_17822;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

//	번호가 xi의 배수인 원판을 di방향으로 ki칸 회전시킨다. di가 0인 경우는 시계 방향, 1인 경우는 반시계 방향이다.
//	원판에 수가 남아 있으면, 인접하면서 수가 같은 것을 모두 찾는다.

	static int N;
	static int M;
	static int T;
	static LinkedList<LinkedList<Integer>> map;

	// print
	static void print(LinkedList<LinkedList<Integer>> map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	// check
	static void check(int[][] map) {

	}

	// 1123 > 3112
	static void clock(LinkedList<Integer> list) {
		list.addFirst(list.removeLast());
	}

	// 3112 > 1123
	static void counterClock(LinkedList<Integer> list) {
		list.addLast(list.removeFirst());
	}

	// 회전
	static void spin(int spinIdx, int direction, int moveCnt) {

		// 시계 방향
		if (direction == 0) {
			for (int i = 0; i < N; i++) {
				if ((i + 1) % spinIdx == 0) {
					for (int j = 0; j < moveCnt; j++) {
						clock(map.get(i));
					}
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				if ((i + 1) % spinIdx == 0) {
					for (int j = 0; j < moveCnt; j++) {
						counterClock(map.get(i));
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		map = new LinkedList<LinkedList<Integer>>();

		for (int i = 0; i < N; i++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			for (int j = 0; j < M; j++) {
				tmp.add(sc.nextInt());
			}
			map.add(tmp);
		}

		while (T-- > 0) {
			print(map);
			int spinIdx = sc.nextInt();
			int direction = sc.nextInt();
			int moveCnt = sc.nextInt();

			spin(spinIdx, direction, moveCnt);
			print(map);
			System.out.println("회전");

		}

	}
}