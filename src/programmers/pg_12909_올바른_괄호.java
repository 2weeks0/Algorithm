package programmers;

import java.util.Stack;

public class pg_12909_올바른_괄호 {
    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (stack.isEmpty() && c == ')') {
                    return false;
                }
                stack.push(c);
            }
            return stack.isEmpty();
        }
    }
}
