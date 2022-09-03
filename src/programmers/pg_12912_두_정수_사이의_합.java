package programmers;

public class pg_12912_두_정수_사이의_합 {
    class Solution {
        public long solution(int a, int b) {
            if (a == b) {
                return a;
            } else if (a < b) {
                return (long) b * (b + 1) / 2 - (long) (a - 1) * a / 2;
            } else {
                return (long) a * (a + 1) / 2 - (long) (b - 1) * b / 2;
            }
        }
    }
}
