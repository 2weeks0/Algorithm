package programmers;

public class pg_12938_최고의_집합 {
    class Solution {
        public int[] solution(int n, int s) {
            if (s < n) {
                return new int[]{-1};
            }

            int d = s / n;
            int mod = s % n;
            int[] answer = new int[n];
            for (int i = n - 1; 0 <= i; i--) {
                if (0 < mod--) {
                    answer[i] = d + 1;
                } else {
                    answer[i] = d;
                }
            }
            return answer;
        }
    }
}
