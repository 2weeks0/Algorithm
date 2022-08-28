package programmers;

public class pg_68935_3진법_뒤집기 {
    class Solution {
        public int solution(int n) {
            StringBuilder sb = new StringBuilder();
            while (3 <= n / 3) {
                sb.append(n % 3);
                n /= 3;
            }
            sb.append(n % 3);
            if (n / 3 != 0) {
                sb.append(n / 3);
            }

            int answer = 0;
            for (int i = 0; i < sb.length(); i++) {
                answer += (int) Math.pow(3, sb.length() - i - 1) * (sb.charAt(i) - '0');
            }
            return answer;
        }
    }
}
