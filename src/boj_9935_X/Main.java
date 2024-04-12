package boj_9935_X;

import java.util.Scanner;

public class Main {

	static int match(String text, String pattern) {
		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			int j = 0;
			while (j < pattern.length() && text.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}
			if (j == pattern.length()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		String bombStr = sc.nextLine();

		StringBuilder result = new StringBuilder(line);
		int index;
		
		while ((index = match(result.toString(), bombStr)) != -1) {
			result.replace(index, index + bombStr.length(), "");
		}

		if (result.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(result);
		}
	}
}
