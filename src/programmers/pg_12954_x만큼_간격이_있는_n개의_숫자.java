package programmers;

public class pg_12954_x만큼_간격이_있는_n개의_숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            for (int i = 0; i < n; i++) {
                answer[i] = (long) x * (i + 1);
            }
            return answer;
        }
    }
}
