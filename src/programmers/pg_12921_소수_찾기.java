package programmers;

import java.util.Arrays;

public class pg_12921_소수_찾기 {
    class Solution {
        public int solution(int n) {
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for (int i = 2; i <= n; i++) {
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }

            int cnt = 0;
            for (boolean b : isPrime) {
                if (b) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
