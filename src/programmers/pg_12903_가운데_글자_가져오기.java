package programmers;

public class pg_12903_가운데_글자_가져오기 {
    class Solution {
        public String solution(String s) {
            if (s.length() % 2 == 0) {
                return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
            } else {
                return s.substring(s.length() / 2, s.length() / 2 + 1);
            }
        }
    }
}
