package programmers;

public class pg_12931_자릿수_더하기 {
    public class Solution {
        public int solution(int n) {
            int answer = 0;
            String str = String.valueOf(n);
            for (int i = 0; i < n; i++) {
                answer += (n / (int) Math.pow(10, i)) % 10;
            }

            return answer;
        }
    }
}
