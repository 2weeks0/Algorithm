package programmers;

public class JadenCase_문자열_만들기 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("3people unFollowed me"));
        System.out.println(new Solution().solution("for the last week"));
    }

    static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();

            boolean toUpgrade = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    answer.append(c);
                    toUpgrade = true;
                } else if (toUpgrade && isLowerCaseAlphabet(c)) {
                    answer.append((char) (c + 'A' - 'a'));
                    toUpgrade = false;
                } else if (!toUpgrade && isUpperCaseAlphabet(c)) {
                    answer.append((char) (c - 'A' + 'a'));
                } else {
                    answer.append(c);
                    toUpgrade = false;
                }
            }
            return answer.toString();
        }

        public boolean isUpperCaseAlphabet(char c) {
            return 'A' <= c && c <= 'Z';
        }

        public boolean isLowerCaseAlphabet(char c) {
            return 'a' <= c && c <= 'z';
        }


    }

}
