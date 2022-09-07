package programmers;

public class pg_12934_정수_제곱근_판별 {
    class Solution {
        public long solution(long n) {
            long sqrt = (long) Math.sqrt(n);
            if (sqrt * sqrt == n) {
                return (sqrt + 1) * (sqrt + 1);
            }
            return -1;
        }
    }
}
