package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2491 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[][] dp = new int[2][n];
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] <= arr[i]) {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                dp[1][i] = dp[1][i - 1] + 1;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer + 1);
        br.close();
    }
}
