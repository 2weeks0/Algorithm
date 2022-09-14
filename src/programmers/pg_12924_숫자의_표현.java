package programmers;

public class pg_12924_숫자의_표현 {
    class Solution {
        public int solution(int n) {
            int[] sum = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                sum[i] = sum[i - 1] + i;
            }

            int answer = 0;
            int left = 0;
            int right = 0;
            while (left < n) {
                if (sum[right] - sum[left] <= n) {
                    if (sum[right] - sum[left] == n) {
                        answer++;
                    }
                    right++;
                } else {
                    left++;
                }
            }
            return answer;
        }
    }
}
