package programmers;

public class pg_12926_시저_암호 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int temp = n;
                while (0 < temp--) {
                    if (c == 'Z') {
                        c = 'A';
                    } else if (c == 'z') {
                        c = 'a';
                    } else if (c != ' ') {
                        c = (char) (c + 1);
                    }
                }
                answer += c;
            }
            return answer;
        }
    }
}