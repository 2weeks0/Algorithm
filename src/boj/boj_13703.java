package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13703 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[][] dp = new long[k + n + 1][n + 1];

        dp[k][0] = 1;
        for (int s = 0; s < n; s++) {
            for (int h = 1; h < k + n; h++) {
                dp[h - 1][s + 1] += dp[h][s];
                dp[h + 1][s + 1] += dp[h][s];
            }
        }

        long answer = 0;
        for (int i = 1; i < k + n + 1; i++) {
            answer += dp[i][n];
        }

        System.out.println(answer);
        br.close();
    }
}
