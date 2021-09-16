package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_3986 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            final String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                final char c = input.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == 'A') {
                    if (stack.peek() == 'A') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    if (stack.peek() == 'B') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }
        System.out.println(answer);
    }
}
