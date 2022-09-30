package programmers;

public class pg_17682_다트_게임 {
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;

            int cur = 0;
            int prev = 0;
            int idx = 0;
            for (int i = 0; i < dartResult.length(); i++) {
                char c = dartResult.charAt(i);
                if ('0' <= c && c <= '9') {
                    answer += prev;
                    prev = cur;
                    cur = 0;
                    continue;
                }

                if (c == '*') {
                    idx = i + 1;
                    cur *= 2;
                    prev *= 2;
                    continue;
                } else if (c == '#') {
                    idx = i + 1;
                    cur *= -1;
                    continue;
                }

                cur = Integer.parseInt(dartResult.substring(idx, i));
                idx = i + 1;

                if (c == 'S') {

                } else if (c == 'D') {
                    cur *= cur;
                } else if (c == 'T') {
                    cur *= cur * cur;
                }
            }
            return answer + prev + cur;
        }
    }
}
