package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_10844 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (0 <= j - 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= MOD;
                }
                if (j + 1 < 10) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= MOD;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
            answer %= MOD;
        }
        System.out.println(answer);
        br.close();
    }
}
