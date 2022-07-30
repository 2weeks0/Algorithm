package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2240 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        // dp[시간][움직인 횟수][위치]
        int[][][] dp = new int[t + 1][w + 1][2];

        for (int i = 0; i < t; i++) {
            int pos = Integer.parseInt(br.readLine()) - 1;
            if (i == 0) {
                if (pos == 0) {
                    dp[1][0][0] = 1;
                } else {
                    dp[1][1][1] = 1;
                }
            } else {
                for (int j = 0; j < w + 1; j++) {
                    if (j == 0) {
                        dp[i + 1][0][0] = dp[i][0][0] + (pos == 0 ? 1 : 0);
                    } else {
                        dp[i + 1][j][0] = Math.max(dp[i][j - 1][1], dp[i][j][0]) + (pos == 0 ? 1 : 0);
                        dp[i + 1][j][1] = Math.max(dp[i][j - 1][0], dp[i][j][1]) + (pos == 1 ? 1 : 0);
                    }
                }
            }
        }


        int answer = 0;
        for (int i = 0; i < w + 1; i++) {
            for (int j = 0; j < 2; j++) {
                answer = Math.max(answer, dp[t][i][j]);
            }
        }

        System.out.println(answer);
        br.close();
    }
}

