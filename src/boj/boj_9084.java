package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_9084 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxCoin = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                maxCoin = Math.max(maxCoin, arr[i]);
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[Math.max(maxCoin, m) + 1];

            for (int coin : arr) {
                dp[coin] += 1;
                for (int i = coin + 1; i <= m; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            bw.append(String.valueOf(dp[m])).append('\n');
        }
        bw.close();
        br.close();
    }
}
