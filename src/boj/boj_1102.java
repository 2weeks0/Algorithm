package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1102 {
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
        int cnt = 0;
        int bit = 0;
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'Y') {
                cnt++;
                bit |= (1 << i);
            }
        }
        int p = Integer.parseInt(br.readLine());

        int answer;
        if (p <= cnt) {
            answer = 0;
        } else if (bit == 0) {
            answer = -1;
        } else {
            int[] dp = new int[1 << n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            answer = recursive(n, graph, p, dp, bit, cnt);
        }
        System.out.println(answer);
        br.close();
    }

    static int recursive(int n, int[][] graph, int p, int[] dp, int bit, int cnt) {
        if (p == cnt) {
            return 0;
        } else if (dp[bit] != Integer.MAX_VALUE) {
            return dp[bit];
        }

        for (int next = 0; next < n; next++) {
            if ((bit & (1 << next)) == (1 << next)) {
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int base = 0; base < n; base++) {
                if ((bit & (1 << base)) == 0) {
                    continue;
                }
                min = Math.min(min, graph[base][next]);
            }
            dp[bit] = Math.min(dp[bit], min + recursive(n, graph, p, dp, bit | (1 << next), cnt + 1));
        }
        return dp[bit];
    }
}