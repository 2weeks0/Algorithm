package programmers;

import java.util.HashSet;

public class N으로_표현 {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 12));
        System.out.println(new Solution().solution(2, 22222222));
    }

    static class Solution {
        HashSet<Integer>[] dp = new HashSet[9];

        public int solution(int N, int number) {
            if (N == number) {
                return 1;
            }

            for(int i = 1; i < 9; i++) {
                dp[i] = new HashSet<>();
            }

            for (int i = 1; i <= 8; i++) {
                int num = N;
                while (Math.log10(num) < i - 1) {
                    num = num * 10 + N;
                }
                dp[i].add(num);
                for (int j = 1; j <= i / 2; j++) {
                    for (int ii : dp[j]) {
                        for (int jj : dp[i - j]) {
                            dp[i].add(ii * jj);
                            dp[i].add(ii + jj);
                            dp[i].add(ii / jj);
                            dp[i].add(jj / ii);
                            dp[i].add(ii - jj);
                            dp[i].add(jj - ii);
                        }
                    }
                }
                if (dp[i].contains(number)) {
                    return i;
                }
                dp[i].remove(0);
            }
            return -1;
        }
    }


}
