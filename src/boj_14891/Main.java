package boj_14891;

import java.util.LinkedList;	
import java.util.Scanner;

//10101111
//01111101
//11001110
//00000010
//2
//3 -1
//1 1
//1 clockwise
//-1 counter clockwise

public class Main {

	static void wise(LinkedList<Integer> wheel, int direction) {
		if (direction == 1) {
			wheel.addFirst(wheel.removeLast());
		} else
			wheel.add(wheel.removeFirst());

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		LinkedList<Integer> w1 = new LinkedList<Integer>();
		String str = sc.nextLine();
		for (int i = 0; i < 8; i++) {
			w1.add(str.charAt(i) - '0');
		}

		LinkedList<Integer> w2 = new LinkedList<Integer>();
		String str2 = sc.nextLine();
		for (int i = 0; i < 8; i++) {
			w2.add(str2.charAt(i) - '0');
		}
		LinkedList<Integer> w3 = new LinkedList<Integer>();
		String str3 = sc.nextLine();
		for (int i = 0; i < 8; i++) {
			w3.add(str3.charAt(i) - '0');
		}
		LinkedList<Integer> w4 = new LinkedList<Integer>();
		String str4 = sc.nextLine();
		for (int i = 0; i < 8; i++) {
			w4.add(str4.charAt(i) - '0');
		}

		int tryCnt = sc.nextInt();

		for (int i = 0; i < tryCnt; i++) {
			int target = sc.nextInt();
			int direction = sc.nextInt();

			if (target == 1) {
				if (w1.get(2) == w2.get(6)) {
					wise(w1, direction);
				} else {
					if (w2.get(2) == w3.get(6)) {
						wise(w1, direction);
						wise(w2, -direction);
					} else {
						if (w3.get(2) == w4.get(6)) {
							wise(w1, direction);
							wise(w2, -direction);
							wise(w3, direction);
						} else {
							wise(w1, direction);
							wise(w2, -direction);
							wise(w3, direction);
							wise(w4, -direction);
						}

					}

				}
			}

			else if (target == 2) {
				if (w2.get(6) == w1.get(2) && w2.get(2) == w3.get(6)) {
					wise(w2, direction);
				} else if (w2.get(6) != w1.get(2) && w2.get(2) == w3.get(6)) {
					wise(w2, direction);
					wise(w1, -direction);
				} else if (w2.get(6) == w1.get(2) && w2.get(2) != w3.get(6)) {
					if (w3.get(2) == w4.get(6)) {
						wise(w2, direction);
						wise(w1, -direction);
						wise(w3, -direction);
					} else {
						wise(w2, direction);
						wise(w1, -direction);
						wise(w3, -direction);
						wise(w4, direction);
					}
				} else if (w2.get(6) != w1.get(2) && w2.get(2) != w3.get(6)) {
					if (w3.get(2) == w4.get(6)) {
						wise(w2, direction);
						wise(w1, -direction);
						wise(w3, -direction);
					} else {
						wise(w2, direction);
						wise(w1, -direction);
						wise(w3, -direction);
						wise(w4, direction);
					}

				}

			} else if (target == 3) {
				if (w2.get(2) == w3.get(6) && w3.get(2) == w4.get(6)) {
					wise(w3, direction);
				} else if (w2.get(2) != w3.get(6) && w3.get(2) == w4.get(6)) {
					if (w1.get(2) == w2.get(6)) {
						wise(w2, -direction);
						wise(w3, direction);
					} else {
						wise(w1, direction);
						wise(w2, -direction);
						wise(w3, direction);
					}
				} else if (w2.get(2) == w3.get(6) && w3.get(2) != w4.get(6)) {
					wise(w3, direction);
					wise(w4, -direction);
				} else if (w2.get(2) != w3.get(6) && w3.get(2) != w4.get(6)) {
					if (w1.get(2) == w2.get(6)) {
						wise(w2, -direction);
						wise(w3, direction);
						wise(w4, -direction);
					} else {
						wise(w1, direction);
						wise(w2, -direction);
						wise(w3, direction);
						wise(w4, -direction);
					}
				}

			} else if (target == 4) {
				if (w4.get(6) == w3.get(2)) {
					wise(w4, direction);
				} else {
					if (w2.get(2) == w3.get(6)) {
						wise(w4, direction);
						wise(w3, -direction);
					} else {
						if (w1.get(2) == w2.get(6)) {
							wise(w4, direction);
							wise(w3, -direction);
							wise(w2, direction);
						} else {
							wise(w4, direction);
							wise(w3, -direction);
							wise(w2, direction);
							wise(w1, -direction);
						}

					}

				}
			}
		}
		System.out.println(w1);
		System.out.println(w2);
		System.out.println(w3);
		System.out.println(w4);

		int sum = 0;
		sum += w1.get(2) * 1;
		sum += w2.get(2) * 2;
		sum += w3.get(2) * 4;
		sum += w4.get(2) * 8;

		System.out.println(sum);
	}
}
