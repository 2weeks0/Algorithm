package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_10799 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String input = br.readLine();
        final Stack<Character> stack = new Stack<>();
        int answer = 0;
        char previous = '(';
        stack.add('(');
        for (int i = 1; i < input.length(); i++) {
            final char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (previous == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;

                }
            }
            previous = c;
        }
        System.out.println(answer);
    }
}
