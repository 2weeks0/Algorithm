package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_20500 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];

        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (int) (((long) dp[i - 1][2] + dp[i - 1][1]) % MOD);
            dp[i][1] = (int) (((long) dp[i - 1][0] + dp[i - 1][2]) % MOD);
            dp[i][2] = (int) (((long) dp[i - 1][1] + dp[i - 1][0]) % MOD);
        }

        System.out.println(dp[n][0]);
        br.close();
    }
}
