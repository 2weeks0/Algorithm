package programmers;

public class pg_12947_하샤드_수 {
    class Solution {
        public boolean solution(int x) {
            int sum = 0;
            int length = String.valueOf(x).length();
            for (int i = 0; i < length; i++) {
                sum += x / (int) Math.pow(10, i) % 10;
            }
            return x % sum == 0;
        }
    }
}
