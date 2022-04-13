package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2098 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                graph[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        answer = Math.min(answer, recursive(n, graph, dp, 0, 1));

        System.out.println(answer);
        br.close();
    }

    static int recursive(int n, int[][] graph, int[][] dp, int current, int bit) {
        if (bit == (1 << n) - 1) {
            return graph[current][0] == 0 ? Integer.MAX_VALUE : graph[current][0];
        } else if (dp[current][bit] != Integer.MAX_VALUE) {
            return dp[current][bit];
        }

        for (int i = 0; i < n; i++) {
            if ((bit & (1 << i)) == (1 << i) || graph[current][i] == 0) {
                continue;
            }
            int temp = graph[current][i] + recursive(n, graph, dp, i, bit | (1 << i));
            if (temp < 0) {
                continue;
            }
            dp[current][bit] = Math.min(dp[current][bit], temp);
        }
        return dp[current][bit];
    }
}
