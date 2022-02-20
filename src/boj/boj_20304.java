package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] hacker = new int[m];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hacker[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        for (int p = 0; p <= n; p++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                min = Math.min(min, getSecurity(p, hacker[i]));
            }
            answer = Math.max(answer, min);
        }

        System.out.println(answer);
    }

    static int getSecurity(int password, int hacker) {
        int result = 0;
        int max = Math.max(password, hacker);
        for (int i = 1; i <= max; i = i << 1) {
            if ((password & i) != (hacker & i)) {
                result++;
            }
        }
        return result;
    }
}
