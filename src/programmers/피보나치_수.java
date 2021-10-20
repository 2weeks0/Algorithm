package programmers;

public class 피보나치_수 {

    class Solution {
        int[] dp = new int[100001];
        public int solution(int n) {
            return fibonacci(n);
        }

        public int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else if (dp[n] != 0) {
                return dp[n];
            }

            int result = (fibonacci(n - 2) + fibonacci(n - 1)) % 1234567;
            dp[n] = result;
            return result;
        }
    }


}
