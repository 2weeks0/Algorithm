package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_1662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int length = 0;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;

        while (idx != input.length()) {
            char c = input.charAt(idx);
            if (isNumber(c)) {
                length++;
            } else if (c == '('){
                stack.add(length - 1);
                stack.add(input.charAt(idx - 1) - '0');
                length = 0;
            } else {
                int m = stack.pop();
                int l = stack.pop();
                length = l + m * length;
            }
            idx++;
        }

        if (stack.isEmpty()) {
            System.out.println(stack.pop());
        } else {
            System.out.println(length);
        }
    }

    static boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

}
