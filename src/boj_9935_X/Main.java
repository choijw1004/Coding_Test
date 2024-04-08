package boj_9935_X;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.next();
		String bombStr = sc.next();
		
		while (true) {
			if (line.contains(bombStr)) {
				line = line.replaceAll(bombStr, "");
			} else
				break;
		}
		if (line.length() == 0) {
			System.out.println("FRULA");
		} else
			System.out.println(line);
	}

}
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String line = sc.next();
//        String bombStr = sc.next();
//
//        StringBuilder sb = new StringBuilder();
//
//        Stack<Character> stack = new Stack<>();
//        int bombLength = bombStr.length();
//
//        for (char ch : line.toCharArray()) {
//            stack.push(ch);
//            if (stack.size() >= bombLength) {
//                boolean isBomb = true;
//                for (int i = 0; i < bombLength; i++) {
//                    if (stack.get(stack.size() - bombLength + i) != bombStr.charAt(i)) {
//                        isBomb = false;
//                        break;
//                    }
//                }
//                if (isBomb) {
//                    // 폭발 문자열 제거
//                    for (int i = 0; i < bombLength; i++) {
//                        stack.pop();
//                    }
//                }
//            }
//        }
//
//        if (stack.isEmpty()) {
//            System.out.println("FRULA");
//        } else {
//            for (char ch : stack) {
//                sb.append(ch);
//            }
//            System.out.println(sb.toString());
//        }
//    }
//}
