package programmers;

import java.util.LinkedList;

public class 괄호_회전하기 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("{"));
    }

    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            LinkedList<Character> stack = new LinkedList<>();
            String temp;
            for (int i = 0; i < s.length(); i++) {
                temp = s.substring(i) + s.substring(0, i);
                boolean isBreaked = false;
                for (int j = 0; j < s.length(); j++) {
                    if (!isPossible(stack, temp.charAt(j))) {
                        answer--;
                        isBreaked = true;
                        break;
                    }
                }
                if (!isBreaked && !stack.isEmpty()) {
                    answer--;
                    stack.clear();
                }
            }
            return answer;
        }

        public boolean isPossible(LinkedList<Character> stack, char c) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
                return true;
            } else if (stack.isEmpty()) {
                return false;
            }

            boolean result;
            switch (stack.peekLast()) {
                case '(':
                    result = c == ')';
                    break;
                case '{':
                    result = c == '}';
                    break;
                case '[':
                    result = c == ']';
                    break;
                default:
                    result = false;
                    break;
            }
            if (result) {
                stack.pollLast();
            } else {
                stack.clear();
            }
            return result;
        }
    }


}
