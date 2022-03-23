package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1904 {
    static final int MOD = 15746;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[Math.max(3, n + 1)];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[n]);
        br.close();
    }
}
