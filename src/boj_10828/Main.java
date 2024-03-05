package boj_10828;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next();

			switch (s) {
			case "push": {
				stack.push(sc.nextInt());
			}
				break;
			case "pop": {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			}
				break;
			case "size": {
				System.out.println(stack.size());

			}
				break;
			case "empty": {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else
					System.out.println(0);

			}
				break;
			case "top": {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else
					System.out.println(stack.get(stack.size()-1));
				break;
			}

			}
		}
		

	}

}
