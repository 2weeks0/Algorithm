package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1003 {
    static int[][] dp = new int[41][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            bw.append(String.valueOf(dp[n][0])).append(' ').append(String.valueOf(dp[n][1])).append('\n');
        }
        bw.close();
        br.close();
    }

    static int[] fibonacci(int n) {
        if (dp[n] != null) {
            return dp[n];
        }

        int[] a = fibonacci(n - 1);
        int[] b = fibonacci(n - 2);
        dp[n] = new int[]{a[0] + b[0], a[1] + b[1]};
        return dp[n];
    }
}
