package boj_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    out.println(stack.size());
                    break;
                case "empty":
                    out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }

        br.close();
        out.close();
    }
}
