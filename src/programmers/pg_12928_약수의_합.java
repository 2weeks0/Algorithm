package programmers;

public class pg_12928_약수의_합 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int sqrt = (int) Math.sqrt(n);
            for (int i = 1; i <= sqrt; i++) {
                if (n % i == 0) {
                    answer += i + (i == n / i ? 0 : n / i);
                }
            }
            return answer;
        }
    }
}
