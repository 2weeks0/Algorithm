package programmers;

public class pg_12925_문자열을_정수로_바꾸기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            char c = s.charAt(0);
            if (c == '+') {
                answer = Integer.parseInt(s.substring(1));
            } else if (c == '-') {
                answer = -Integer.parseInt(s.substring(1));
            } else {
                answer = Integer.parseInt(s);
            }
            return answer;
        }
    }
}
