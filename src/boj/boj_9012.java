package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9012 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.clear();
            final String input = br.readLine();
            int j;
            for (j = 0; j < input.length(); j++) {
                final char c = input.charAt(j);
                if (c =='(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        break;
                    }
                    stack.pop();
                }
            }
            if (j == input.length()) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
