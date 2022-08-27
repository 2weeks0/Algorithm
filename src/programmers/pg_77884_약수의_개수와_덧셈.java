package programmers;

public class pg_77884_약수의_개수와_덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right; i++) {
                int cnt = getCompCount(i);
                if (cnt % 2 == 0) {
                    answer += i;
                } else {
                    answer -= i;
                }
            }
            return answer;
        }

        int getCompCount(int num) {
            int result = 0;

            int limit = (int) Math.sqrt(num);
            for (int i = 1; i <= limit; i++) {
                if (num % i == 0) {
                    result += 2;
                }
            }
            if (limit * limit == num) {
                result--;
            }
            return result;
        }
    }
}
