package programmers;

import java.util.Arrays;

public class 조이스틱 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("JEROEN"));
        System.out.println(new Solution().solution("JAN"));
    }


    static class Solution {
        int answer = 0;
        int cursor = 0;

        public int solution(String name) {
            char[] current = new char[name.length()];
            Arrays.fill(current, 'A');

            while (!isEqual(current, name)) {
                moveCursor(current, name);
                changeAlphabet(current, name);
            }

            return answer;
        }

        public boolean isEqual(char[] current, String name) {
            for (int i = 0; i < name.length();i ++) {
                if (current[i] != name.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public void moveCursor(char[] current, String name) {
            if (current[cursor] != name.charAt(cursor)) {
                return;
            }

            int moveRight = cursor;
            int moveLeft = cursor;
            for (int i = 0; i < name.length(); i++) {
                moveRight = (moveRight + 1) % name.length();
                if (current[moveRight] != name.charAt(moveRight)) {
                    answer += i + 1;
                    cursor = moveRight;
                    break;
                }
                moveLeft = moveLeft - 1 < 0 ? name.length() - 1 : moveLeft - 1;
                if (current[moveLeft] != name.charAt(moveLeft)) {
                    answer += i + 1;
                    cursor = moveLeft;
                    break;
                }
            }
        }

        public void changeAlphabet(char[] current, String name) {
            int temp = Math.min(Math.abs(name.charAt(cursor) - current[cursor]), 'Z' - name.charAt(cursor) + current[cursor] - 'A' + 1);
            answer += temp;
            System.out.printf("%c -> %c : %d\n", current[cursor], name.charAt(cursor), temp);
            current[cursor] = name.charAt(cursor);
        }
    }


}
